package by.softclub.depositservice.repository;

import by.softclub.depositservice.entity.AgreementStatus;
import by.softclub.depositservice.entity.Deposit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

    @Query("SELECT d FROM Deposit d WHERE" +
            "(:clientId IS NULL OR d.clientId = :clientId) AND " +
            "(:agreementCode IS NULL OR d.agreementCode LIKE CONCAT('%', :agreementCode, '%')) AND " +
            "(:agreementType IS NULL OR d.agreementType LIKE CONCAT('%', :agreementType, '%')) AND " +
            "(:amountFrom IS NULL OR d.amount >= :amountFrom) AND " +
            "(:amountTo IS NULL OR d.amount <= :amountTo) AND" +
            "(:interestRateFrom IS NULL OR d.interestRate >= :interestRateFrom) AND" +
            "(:interestRateTo IS NULL OR d.amount <= :interestRateTo) AND" +
            "(:durationFrom IS NULL OR d.duration >= :durationFrom) AND" +
            "(:durationTo IS NULL OR d.duration <= :durationTo) AND" +
            "(:signDateFrom IS NULL OR d.signDate >= :signDateFrom) AND" +
            "(:signDateTo IS NULL OR d.signDate <= :signDateTo) AND" +
            "(:endDateFrom IS NULL OR d.endDate >= :endDateFrom) AND" +
            "(:endDateTo IS NULL OR d.endDate <= :endDateTo) AND" +
            "(:status IS NULL OR d.status = :status) AND" +
            "(:replenishment IS NULL OR d.replenishment = :replenishment) AND" +
            "(:withdrawal IS NULL OR d.withdrawal = :withdrawal) AND" +
            "(:minBalanceFrom IS NULL OR d.minBalance >= :minBalanceFrom) AND" +
            "(:minBalanceTo IS NULL OR d.minBalance <= :minBalanceTo) AND" +
            "(:paymentFrequencyFrom IS NULL OR d.paymentFrequency >= :paymentFrequencyFrom) AND" +
            "(:paymentFrequencyTo IS NULL OR d.paymentFrequency <= :paymentFrequencyTo)")
    List<Deposit> findByFilters(@Param("clientId") Long clientId,
                                @Param("agreementCode") String agreementCode,
                                @Param("agreementType") String agreementType,
                                @Param("amountFrom") Double amountFrom,
                                @Param("amountTo") Double amountTo,
                                @Param("interestRateFrom") Float interestRateFrom,
                                @Param("interestRateTo") Float interestRateTo,
                                @Param("durationFrom") Integer durationFrom,
                                @Param("durationTo") Integer durationTo,
                                @Param("signDateFrom") LocalDate signDateFrom,
                                @Param("signDateTo") LocalDate signDateTo,
                                @Param("endDateFrom") LocalDate endDateFrom,
                                @Param("endDateTo") LocalDate endDateTo,
                                @Param("status") AgreementStatus status,
                                @Param("replenishment") Boolean replenishment,
                                @Param("withdrawal") Boolean withdrawal,
                                @Param("minBalanceFrom") Double minBalanceFrom,
                                @Param("minBalanceTo") Double minBalanceTo,
                                @Param("paymentFrequencyFrom") Integer paymentFrequencyFrom,
                                @Param("paymentFrequencyTo") Integer paymentFrequencyTo,
                                Sort sort);

    Deposit findById(long id);
}
