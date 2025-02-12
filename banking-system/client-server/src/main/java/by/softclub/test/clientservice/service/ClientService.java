package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.dto.ClientDto;
import by.softclub.test.clientservice.models.Client;
import by.softclub.test.clientservice.repo.ClientRepository;
import by.softclub.test.clientservice.utils.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;


    public List<ClientDto> readAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(clientMapper::mapToClientDto)
                .collect(Collectors.toList());
    }

    public Client getByLogin(String email) {
        Client client = clientRepository.findByEmail(email);
        return client;

    }

    public void deleteId(long Id) {
        Client client = clientRepository.findById(Id).orElseThrow();
        clientRepository.delete(client);
    }


    public void addClient(String username, String email, String telephone) {
        ZoneId zone = ZoneId.of("Belarus/Minsk");
        LocalDate today = LocalDate.now(zone);
        Client client = new Client();
        client.setUsername(username);
        //client.setBday(birthDate);
        //client.setPassport_id(Long.valueOf(passport_id));
        client.setEmail(email);
        client.setTelephone(telephone);
        //client.setRegistration(registration);
        clientRepository.save(client);

    }


    public void addClient(String email, String username) {
        //  ZoneId zone = ZoneId.of("Belarus/Minsk");
        // LocalDate today = LocalDate.now(zone);
        //  Statuses status = new Statuses(1);
        Client client = new Client();
        client.setUsername(username);
        client.setEmail(email);
        //  client.setStatus(status);
        clientRepository.save(client);
    }
}
