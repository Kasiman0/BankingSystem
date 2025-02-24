package by.softclub.depositservice.repository;

import by.softclub.depositservice.entity.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<OperationHistory, Long> {
    List<OperationHistory> findById(long id);
}
