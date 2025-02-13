package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.dto.ClientCreateRequest;
import by.softclub.test.clientservice.dto.ClientUpdateRequest;
import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.entity.ClientStatus;
import by.softclub.test.clientservice.repository.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
    public Client createClient(ClientCreateRequest request) {
        if (clientRepository.existsByPassportNumber(request.getPassportNumber())) {
            throw new RuntimeException("Client with this passport number already exists");
        }
        if (clientRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new RuntimeException("Client with this phone number already exists");
        }
        if (clientRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Client with this email already exists");
        }
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

    @Transactional
    public Client updateClient(ClientUpdateRequest request) {
        if(!clientRepository.existsById(request.getId())) {
            throw new RuntimeException("Client with this id does not exist");
        }
        Client client = clientRepository.findById(request.getId());
        if(request.getFullName() != null) {
            client.setFullName(request.getFullName());
        }
        if(request.getEmail() != null) {
            client.setEmail(request.getEmail());
        }
        if(request.getPhoneNumber() != null) {
            client.setPhoneNumber(request.getPhoneNumber());
        }
        if(request.getPostalCode() != null) {
            client.setPostalCode(request.getPostalCode());
        }
        if(request.getAddress() != null) {
            client.setAddress(request.getAddress());
        }
        if(request.getStatus()!= null) {
            client.setClientStatus(request.getStatus());
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new RuntimeException("Client with this id does not exist");
        }
        clientRepository.deleteById(id);
    }
}
