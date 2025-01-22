package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.repository.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

}
