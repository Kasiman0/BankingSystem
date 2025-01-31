package by.softclub.test.clientservice.utils;

import by.softclub.test.clientservice.dto.ClientDto;
import by.softclub.test.clientservice.models.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDto mapToClientDto(Client client)
    {
        //TODO check
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setUsername(client.getUsername());
        dto.setEmail(client.getEmail());
       // dto.setStatus(client.getStatus());
        return dto;
    }

    public Client mapToClient(ClientDto dto)
    {
//TODO check
        Client client=new Client();
        client.setId(dto.getId());
        client.setUsername(dto.getUsername());
        client.setEmail(dto.getEmail());
        //  client.setStatus(dto.getStatus());
        return client;
    }


}
