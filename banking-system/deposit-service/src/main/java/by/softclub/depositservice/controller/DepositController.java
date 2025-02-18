package by.softclub.depositservice.controller;

import by.softclub.depositservice.dto.DepositCreateRequest;
import by.softclub.depositservice.entity.Deposit;
import by.softclub.depositservice.service.DepositService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deposits")
@Tag(name="Deposits", description = "API for managing deposit agreements")
@SecurityRequirement(name="basicAuth")
public class DepositController {
    private final DepositService depositService;

    public DepositController(DepositService depositService) {this.depositService = depositService;}

    @PostMapping("/new")
    public ResponseEntity<Deposit> createDeposit(@Valid @RequestBody DepositCreateRequest request) {
        return ResponseEntity.ok(depositService.createDeposit(request));
    }
}
