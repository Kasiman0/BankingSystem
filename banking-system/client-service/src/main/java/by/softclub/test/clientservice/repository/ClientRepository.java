package by.softclub.test.clientservice.repository;

import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.entity.ClientStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE" +
            "(:fullName IS NULL OR LOWER(c.fullName) LIKE LOWER(CONCAT('%', :fullName, '%'))) AND" +
            "(:dobFrom IS NULL OR c.dob >= :dobFrom) AND " +
            "(:dobTo IS NULL OR c.dob <= :dobTo) AND " +
            "(:passportNumber IS NULL OR c.passportNumber LIKE CONCAT('%', :passportNumber, '%')) AND " +
            "(:email IS NULL OR c.email LIKE CONCAT('%', :email, '%')) AND " +
            "(:phoneNumber IS NULL OR c.phoneNumber LIKE CONCAT('%', :phoneNumber, '%')) AND " +
            "(:postalCode IS NULL OR c.postalCode LIKE CONCAT('%', :postalCode, '%')) AND " +
            "(:address IS NULL OR LOWER(c.address) LIKE LOWER(CONCAT('%', :address, '%'))) AND " +
            "(:clientStatus IS NULL OR c.clientStatus = :clientStatus)")
    List<Client> findByFilters(@Param("fullName") String fullName,
                               @Param("dobFrom") LocalDate dobFrom,
                               @Param("dobTo") LocalDate dobTo,
                               @Param("passportNumber") String passportNumber,
                               @Param("email") String email,
                               @Param("phoneNumber") String phoneNumber,
                               @Param("postalCode") String postalCode,
                               @Param("address") String address,
                               @Param("clientStatus") ClientStatus clientStatus,
                               Sort sort);
}
