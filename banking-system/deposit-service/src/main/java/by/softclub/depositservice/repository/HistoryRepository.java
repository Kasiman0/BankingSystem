package by.softclub.depositservice.repository;

import by.softclub.depositservice.entity.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<OperationHistory, Long> {

}
