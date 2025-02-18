package by.softclub.depositservice.repository;

import by.softclub.depositservice.entity.Conditions;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConditionsRepository extends JpaRepository<Conditions, Integer> {
    @Query("SELECT c FROM Conditions c WHERE" +
            ":agreementType IS NULL OR c.agreementType LIKE (CONCAT('%', :agreementType, '%')) AND " +
            ":replenishment IS NULL OR c.replenishment = :replenishment AND " +
            ":withdrawal IS NULL OR c.withdrawal = :withdrawal AND " +
            ":minBalanceFrom IS NULL OR c.minBalance >= :minBalanceFrom AND " +
            ":minBalanceTo IS NULL OR c.minBalance <= :minBalanceTo AND " +
            ":paymentFrequencyFrom IS NULL OR c.paymentFrequency >= :paymentFrequencyFrom AND " +
            ":paymentFrequencyTo IS NULL OR c.paymentFrequency <= :paymentFrequencyTo")
    List<Conditions> findByFilters(@Param("agreementType") String agreementType,
                                   @Param("replenishment") Boolean replenishment,
                                   @Param("withdrawal") Boolean withdrawal,
                                   @Param("minBalanceFrom") Float minBalanceFrom,
                                   @Param("minBalanceTo") Float minBalanceTo,
                                   @Param("paymentFrequencyFrom") Integer paymentFrequencyFrom,
                                   @Param("paymentFrequencyTo") Integer paymentFrequencyTo,
                                   Sort sort);

    Conditions findById(int id);

    boolean existsByReplenishmentAndWithdrawalAndMinBalanceAndPaymentFrequency(boolean replenishment, boolean withdrawal, float minBalance, int paymentFrequency);
}
