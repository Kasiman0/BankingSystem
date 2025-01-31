package by.softclub.test.clientservice.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.softclub.test.clientservice.models.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String Email);
}
