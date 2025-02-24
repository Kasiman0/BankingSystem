package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.dto.ClientCreateRequest;
import by.softclub.test.clientservice.dto.ClientUpdateRequest;
import by.softclub.test.clientservice.entity.ChangeHistory;
import by.softclub.test.clientservice.entity.ChangeType;
import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.entity.ClientStatus;
import by.softclub.test.clientservice.repository.ClientRepository;
import by.softclub.test.clientservice.repository.HistoryRepository;
import by.softclub.test.clientservice.security.EmailValidation;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final HistoryRepository historyRepository;

    public ClientService(ClientRepository clientRepository, HistoryRepository historyRepository) {
        this.clientRepository = clientRepository;
        this.historyRepository = historyRepository;
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
        if(request.getPassportNumber().length()!=14){
            throw new RuntimeException("Passport number length must be 14");
        }
        if(request.getPhoneNumber().length()!=13){
            throw new RuntimeException("Phone number length must be 13");
        }
        if(!EmailValidation.isValid(request.getEmail())){
            throw new RuntimeException("Invalid email address");
        }
        if(request.getPostalCode() != null && request.getPostalCode().length()!=6){
            throw new RuntimeException("Postal code length must be 6");
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
        clientRepository.save(client);

        ChangeHistory changeHistory = new ChangeHistory();
        changeHistory.setType(ChangeType.C);
        changeHistory.setClientId(client.getId());
        changeHistory.setChangeDate(client.getRegistrationDate());
        historyRepository.save(changeHistory);

        return client;
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

        ChangeHistory changeHistory = new ChangeHistory();
        changeHistory.setType(ChangeType.U);
        changeHistory.setClientId(client.getId());
        changeHistory.setChangeDate(LocalDate.now());

        if(request.getFullName() != null) {
            changeHistory.setColumnName("full_name");
            changeHistory.setOldValue(client.getFullName());
            changeHistory.setNewValue(request.getFullName());
            historyRepository.save(changeHistory);
            client.setFullName(request.getFullName());
        }
        if(request.getEmail() != null) {
            changeHistory.setColumnName("email");
            changeHistory.setOldValue(client.getEmail());
            changeHistory.setNewValue(request.getEmail());
            historyRepository.save(changeHistory);
            client.setEmail(request.getEmail());
        }
        if(request.getPhoneNumber() != null) {
            changeHistory.setColumnName("phone_number");
            changeHistory.setOldValue(client.getPhoneNumber());
            changeHistory.setNewValue(request.getPhoneNumber());
            historyRepository.save(changeHistory);
            client.setPhoneNumber(request.getPhoneNumber());
        }
        if(request.getPostalCode() != null) {
            changeHistory.setColumnName("postal_code");
            changeHistory.setOldValue(client.getPostalCode());
            changeHistory.setNewValue(request.getPostalCode());
            historyRepository.save(changeHistory);
            client.setPostalCode(request.getPostalCode());
        }
        if(request.getAddress() != null) {
            changeHistory.setColumnName("address");
            changeHistory.setOldValue(client.getAddress());
            changeHistory.setNewValue(request.getAddress());
            historyRepository.save(changeHistory);
            client.setAddress(request.getAddress());
        }
        if(request.getStatus()!= null) {
            changeHistory.setColumnName("status");
            changeHistory.setOldValue(client.getClientStatus().toString());
            changeHistory.setNewValue(request.getStatus().toString());
            historyRepository.save(changeHistory);
            client.setClientStatus(request.getStatus());
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new RuntimeException("Client with this id does not exist");
        }

        ChangeHistory changeHistory = new ChangeHistory();
        changeHistory.setType(ChangeType.D);
        changeHistory.setClientId(id);
        changeHistory.setChangeDate(LocalDate.now());
        historyRepository.save(changeHistory);

        clientRepository.deleteById(id);
    }

    public Boolean checkClient(long id) {
        if(!clientRepository.existsById(id)) {
            return false;
        }

        Client client = clientRepository.findById(id);

        return client.getClientStatus() == ClientStatus.ACTIVE;
    }

    public Client getById(long id) {
        return clientRepository.findById(id);
    }
}
