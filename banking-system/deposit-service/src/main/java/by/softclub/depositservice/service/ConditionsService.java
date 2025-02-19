package by.softclub.depositservice.service;

import by.softclub.depositservice.dto.ConditionsCreateRequest;
import by.softclub.depositservice.dto.ConditionsUpdateRequest;
import by.softclub.depositservice.entity.Conditions;
import by.softclub.depositservice.repository.ConditionsRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionsService {

    private final ConditionsRepository conditionsRepository;

    ConditionsService(ConditionsRepository conditionsRepository) {this.conditionsRepository = conditionsRepository;}

    @Transactional
    public Conditions createConditions(ConditionsCreateRequest request) {
        if(request.getMinBalance() < 0 ) {
            throw new RuntimeException("Invalid min balance");
        }
        if(request.getPaymentFrequency() < 0)
        {
            throw new RuntimeException("Invalid payment frequency");
        }
        if(conditionsRepository.existsByReplenishmentAndWithdrawalAndMinBalanceAndPaymentFrequency(
                request.isReplenishment(), request.isWithdrawal(), request.getMinBalance(), request.getPaymentFrequency())) {
            throw new RuntimeException("A template with these conditions already exists");
        }

        Conditions conditions = new Conditions();
        conditions.setAgreementType(request.getAgreementType());
        conditions.setReplenishment(request.isReplenishment());
        conditions.setWithdrawal(request.isWithdrawal());
        conditions.setMinBalance(request.getMinBalance());
        conditions.setPaymentFrequency(request.getPaymentFrequency());

        return conditionsRepository.save(conditions);
    }

    public List<Conditions> getConditions(String agreementType, Boolean replenishment, Boolean withdrawal,
                                          Float minBalanceFrom, Float minBalanceTo, Integer paymentFrequencyFrom,
                                          Integer paymentFrequencyTo, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        if(agreementType == null && replenishment == null && withdrawal == null &&
                minBalanceFrom == null && minBalanceTo == null &&
                paymentFrequencyFrom == null && paymentFrequencyTo == null) {
            return conditionsRepository.findAll(sort);
        }
        return conditionsRepository.findByFilters(agreementType, replenishment, withdrawal,
                minBalanceFrom, minBalanceTo, paymentFrequencyFrom, paymentFrequencyTo, sort);
    }

    @Transactional
    public Conditions updateConditions(ConditionsUpdateRequest request) {
        if(!conditionsRepository.existsById(request.getId())) {
            throw new RuntimeException("Conditions with this id do not exist");
        }
        Conditions conditions = conditionsRepository.findById(request.getId());
        if(request.getReplenishment() != null) {
            conditions.setReplenishment(request.getReplenishment());
        }
        if(request.getWithdrawal() != null) {
            conditions.setWithdrawal(request.getWithdrawal());
        }
        if(request.getMinBalance() != null) {
            conditions.setMinBalance(request.getMinBalance());
        }
        if(request.getPaymentFrequency() != null) {
            conditions.setPaymentFrequency(request.getPaymentFrequency());
        }
        return conditionsRepository.save(conditions);
    }

    @Transactional
    public void deleteConditions(int id) {
        if(!conditionsRepository.existsById(id)) {
            throw new RuntimeException("Conditions template with this id does not exist");
        }
        conditionsRepository.deleteById(id);
    }
}
