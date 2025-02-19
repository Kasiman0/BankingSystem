package by.softclub.depositservice.service;

import by.softclub.depositservice.dto.DepositCreateRequest;
import by.softclub.depositservice.dto.DepositOperationRequest;
import by.softclub.depositservice.entity.*;
import by.softclub.depositservice.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class DepositService {
    private final DepositRepository depositRepository;
    private final ConditionsRepository conditionsRepository;
    private final HistoryRepository historyRepository;

    public DepositService(DepositRepository depositRepository,
                          ConditionsRepository conditionsRepository,
                          HistoryRepository historyRepository) {
        this.depositRepository = depositRepository;
        this.conditionsRepository = conditionsRepository;
        this.historyRepository = historyRepository;
    }

    @Transactional
    public Deposit createDeposit(DepositCreateRequest request) {
        if(Objects.equals(request.getAgreementType(), "CUSTOM")) {
            if(request.getReplenishment() == null || request.getWithdrawal() == null ||
                    request.getMinBalance() == null || request.getPaymentFrequency() == null) {
                throw new RuntimeException("Custom agreement conditions not provided");
            }
            if(request.getMinBalance()<0 || request.getMinBalance()>1) {
                throw new RuntimeException("Min balance should be between 0 and 1");
            }
        }
        Deposit deposit = new Deposit();
        deposit.setClientId(request.getClientId());
        deposit.setAgreementCode(request.getAgreementCode());
        deposit.setAgreementType(request.getAgreementType());
        deposit.setAmount(request.getAmount());
        deposit.setInterestRate(request.getInterestRate());
        deposit.setDuration(request.getDuration());
        deposit.setSignDate(LocalDate.now());
        deposit.setEndDate(deposit.getSignDate().plusMonths(deposit.getDuration()));
        deposit.setStatus(AgreementStatus.ACTIVE);
        if(!Objects.equals(deposit.getAgreementType(), "CUSTOM")) {
            Conditions conditions = conditionsRepository.findByAgreementType(deposit.getAgreementType());
            deposit.setReplenishment(conditions.getReplenishment());
            deposit.setWithdrawal(conditions.getWithdrawal());
            deposit.setMinBalance(conditions.getMinBalance());
            deposit.setPaymentFrequency(conditions.getPaymentFrequency());
        }
        else {
            deposit.setReplenishment(request.getReplenishment());
            deposit.setWithdrawal(request.getWithdrawal());
            deposit.setMinBalance(request.getMinBalance());
            deposit.setPaymentFrequency(request.getPaymentFrequency());
        }
        if(deposit.getAmount() < deposit.getMinBalance()) {
            throw new RuntimeException("Not enough funds to create a deposit");
        }
        depositRepository.save(deposit);

        OperationHistory history = new OperationHistory();
        history.setDepositId(deposit.getId());
        history.setChangeType(ChangeType.C);
        history.setOperationDate(LocalDate.now());
        historyRepository.save(history);

        return deposit;
    }

    public List<Deposit> getDeposits(Long clientId, String agreementCode, String agreementType,
                                     Double amountFrom, Double amountTo, Float interestRateFrom, Float interestRateTo,
                                     Integer durationFrom, Integer durationTo, LocalDate signDateFrom, LocalDate signDateTo,
                                     LocalDate endDateFrom, LocalDate endDateTo, AgreementStatus status, Boolean replenishment,
                                     Boolean withdrawal, Double minBalanceFrom, Double minBalanceTo,
                                     Integer paymentFrequencyFrom, Integer paymentFrequencyTo, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        if(clientId == null && agreementCode == null && agreementType == null && amountFrom == null && amountTo == null &&
                interestRateFrom == null && interestRateTo == null && durationFrom == null && durationTo == null &&
                signDateFrom == null && signDateTo == null && endDateFrom == null && endDateTo == null &&
                status == null && replenishment == null && withdrawal == null && minBalanceFrom == null &&
                minBalanceTo == null && paymentFrequencyFrom == null && paymentFrequencyTo == null) {
            return depositRepository.findAll(sort);
        }
        return depositRepository.findByFilters(clientId, agreementCode, agreementType, amountFrom, amountTo,
                interestRateFrom, interestRateTo, durationFrom, durationTo, signDateFrom, signDateTo,
                endDateFrom, endDateTo, status, replenishment, withdrawal, minBalanceFrom, minBalanceTo,
                paymentFrequencyFrom, paymentFrequencyTo, sort);
    }

    @Transactional
    public Deposit depositOperation(DepositOperationRequest request) {
        Deposit deposit = depositRepository.findById(request.getId());
        OperationHistory history = new OperationHistory();
        switch (request.getOperation()) {
            case Operations.W:
                if(!deposit.getWithdrawal()) {
                    throw new RuntimeException("Withdrawal not available for this deposit");
                }
                if(request.getSum() == null) {
                    throw new RuntimeException("Sum not provided");
                }
                if((deposit.getAmount() - request.getSum()) < deposit.getMinBalance()) {
                    throw new RuntimeException("Withdrawal exceeds minimal balance");
                }
                deposit.setAmount(deposit.getAmount() - request.getSum());

                history.setOperation(Operations.W);
                history.setSum(-request.getSum());
                history.setNewBalance(deposit.getAmount());

                break;

            case Operations.R:
                if(!deposit.getReplenishment()) {
                    throw new RuntimeException("Replenishment not available for this deposit");
                }
                if(request.getSum() == null) {
                    throw new RuntimeException("Sum not provided");
                }
                deposit.setAmount(deposit.getAmount() + request.getSum());

                history.setOperation(Operations.R);
                history.setSum(request.getSum());
                history.setNewBalance(deposit.getAmount());

                break;

            case Operations.A:
                if(deposit.getStatus() == AgreementStatus.ACTIVE) {
                    throw new RuntimeException("Deposit is already active");
                }
                deposit.setStatus(AgreementStatus.ACTIVE);

                history.setOperation(Operations.A);

                break;

            case Operations.S:
                if(deposit.getStatus() == AgreementStatus.SUSPENDED) {
                    throw new RuntimeException("Deposit is already suspended");
                }
                deposit.setStatus(AgreementStatus.SUSPENDED);

                history.setOperation(Operations.S);

                break;

            case Operations.C:
                if(deposit.getStatus() == AgreementStatus.CLOSED) {
                    throw new RuntimeException("Deposit is already closed");
                }
                deposit.setStatus(AgreementStatus.CLOSED);

                history.setOperation(Operations.C);

                break;
        }

        history.setDepositId(deposit.getId());
        history.setChangeType(ChangeType.U);
        history.setOperationDate(LocalDate.now());
        historyRepository.save(history);

        return depositRepository.save(deposit);
    }

    @Transactional
    public void deleteDeposit(long id) {
        if(!depositRepository.existsById(id)) {
            throw new RuntimeException("Deposit does not exist");
        }
        Deposit deposit = depositRepository.findById(id);
        if(deposit.getStatus()!=AgreementStatus.CLOSED) {
            throw new RuntimeException("Deposit is active or suspended");
        }

        OperationHistory history = new OperationHistory();
        history.setDepositId(id);
        history.setChangeType(ChangeType.D);
        history.setOperationDate(LocalDate.now());
        historyRepository.save(history);

        depositRepository.deleteById(id);
    }
}
