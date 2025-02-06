package by.softclub.test.clientservice.controller;


import by.softclub.test.clientservice.dto.ClientRequest;
import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.entity.ClientStatus;
import by.softclub.test.clientservice.service.ClientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/clients")
@Tag(name="Clients", description = "API for managing clients")
@SecurityRequirement(name = "basicAuth")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {this.clientService = clientService;}

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientRequest request)
    {
        return ResponseEntity.ok(clientService.createClient(request));
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients (
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dobTo,
            @RequestParam(required = false) String passportNumber,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String postalCode,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) ClientStatus clientStatus,
            @RequestParam(defaultValue = "full_name") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection
            ) {
        return ResponseEntity.ok(clientService.getClients(fullName, dobFrom, dobTo, passportNumber, email, phoneNumber,
                                                          postalCode, address, clientStatus, sortBy, sortDirection));
    }
}
