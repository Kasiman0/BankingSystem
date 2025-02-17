package by.softclub.depositservice.repository;

import by.softclub.depositservice.entity.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
