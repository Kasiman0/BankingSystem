package by.softclub.test.clientservice.repository;

import by.softclub.test.clientservice.entity.ChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<ChangeHistory, Long> {

}