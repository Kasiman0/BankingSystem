package by.softclub.test.clientservice.repo;

import by.softclub.test.clientservice.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, String> {
    Passport findByNumber(String number);
}
