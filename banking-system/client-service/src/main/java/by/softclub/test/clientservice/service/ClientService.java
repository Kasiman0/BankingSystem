package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.dto.ClientRequest;
import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client createClient(ClientRequest request) {
        //пока без валидации
        Client client = new Client();
        client.setFullName(request.getFullName());
        client.setDob(request.getDob());
        client.setPassportNumber(request.getPassportNumber());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setPostalCode(request.getPostalCode());
        client.setAddress(request.getAddress());
        client.setClientStatus(request.getClientStatus());
        return clientRepository.save(client);
    }
}
