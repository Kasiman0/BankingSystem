package by.softclub.test.clientservice.controller;


import by.softclub.test.clientservice.dto.ClientRequest;
import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/clients")
@Tag(name="Clients", description = "API for managing clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {this.clientService = clientService;}

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientRequest request)
    {
        return ResponseEntity.ok(clientService.createClient(request));
    }

}
