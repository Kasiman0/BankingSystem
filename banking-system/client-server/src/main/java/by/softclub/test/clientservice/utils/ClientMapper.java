package by.softclub.test.clientservice.utils;

import by.softclub.test.clientservice.dto.ClientDto;
import by.softclub.test.clientservice.models.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientMapper {

    public ClientDto mapToClientDto(Client client)
    {
        ClientDto dto = new ClientDto();
        dto.setId(client.getId());
        dto.setUsername(client.getUsername());
        dto.setEmail(client.getEmail());
        dto.setTelephone(client.getTelephone());
        dto.setPassportSeriesAndNumber(client.getPassportSeriesAndNumber());
       // dto.setStatus(client.getStatus());
        return dto;
    }

    public Client mapToClient(ClientDto dto)
    {
        Client client=new Client();
        client.setId(dto.getId());
        client.setUsername(dto.getUsername());
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        client.setPassportSeriesAndNumber(dto.getPassportSeriesAndNumber());
        //  client.setStatus(dto.getStatus());
        return client;
    }


}
