package by.softclub.test.clientservice.repo;

import by.softclub.test.clientservice.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
    Optional<Registration> findById(Integer id);

}
