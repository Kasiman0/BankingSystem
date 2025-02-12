package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.dto.ClientRegistrationRequest;
import by.softclub.test.clientservice.dto.ClientRequest;
import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.entity.ClientStatus;
import by.softclub.test.clientservice.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client createClient(ClientRegistrationRequest request) {
        //пока без валидации
        Client client = new Client();
        client.setFullName(request.getFullName());
        client.setDob(LocalDate.parse(request.getDob()));
        client.setPassportNumber(request.getPassportNumber());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setPostalCode(request.getPostalCode());
        client.setAddress(request.getAddress());
        client.setClientStatus(ClientStatus.ACTIVE);
        client.setRegistrationDate(LocalDate.now());
        return clientRepository.save(client);
    }

    public List<Client> getClients(String fullName, LocalDate dobFrom, LocalDate dobTo, String passportNumber,
                                   String email, String phoneNumber, String postalCode, String address,
                                   ClientStatus clientStatus, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        if(fullName == null && dobFrom == null && dobTo == null && passportNumber == null && email == null
            && phoneNumber == null && postalCode == null && address == null && clientStatus == null) {
        return clientRepository.findAll(sort);
        }
        return clientRepository.findByFilters(fullName, dobFrom, dobTo, passportNumber, email, phoneNumber,
                postalCode, address, clientStatus, sort);
    }
}
