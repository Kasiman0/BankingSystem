package by.softclub.test.clientservice.controller;


import by.softclub.test.clientservice.dto.ClientCreateRequest;
import by.softclub.test.clientservice.dto.ClientUpdateRequest;
import by.softclub.test.clientservice.entity.Client;
import by.softclub.test.clientservice.entity.ClientStatus;
import by.softclub.test.clientservice.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/clients")
@Tag(name="Clients", description = "API for managing clients")
@SecurityRequirement(name = "basicAuth")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {this.clientService = clientService;}

    @Operation(
            summary = "Create",
            description = "Создает и вносит нового клиента в бд"
    )
    @PostMapping("/new")
    public ResponseEntity<Client> createClient(@Valid @RequestBody ClientCreateRequest request) {
        return ResponseEntity.ok(clientService.createClient(request));
    }

    @Operation(
            summary = "Read",
            description = "Находит в бд клиентов с указанными параметрами"
    )
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
            @RequestParam(defaultValue = "fullName") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection
            ) {
        return ResponseEntity.ok(clientService.getClients(fullName, dobFrom, dobTo, passportNumber, email, phoneNumber,
                                                          postalCode, address, clientStatus, sortBy, sortDirection));
    }

    @Operation(
            summary = "Update",
            description = "Обновляет поля клиентов в бд"
    )
    @PostMapping("/update")
    public ResponseEntity<Client> updateClient(@Valid @RequestBody ClientUpdateRequest request)
    {
        return ResponseEntity.ok(clientService.updateClient(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id)
    {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Status check",
            description = "Проверяет существование и статус клиента"
    )
    @GetMapping("/check/{id}")
    public ResponseEntity<Boolean> checkClient(@PathVariable long id){
        return ResponseEntity.ok(clientService.checkClient(id));
    }

    @Operation(
            summary = "get client",
            description = "get client by id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable long id){
        return ResponseEntity.ok(clientService.getById(id));
    }
}
