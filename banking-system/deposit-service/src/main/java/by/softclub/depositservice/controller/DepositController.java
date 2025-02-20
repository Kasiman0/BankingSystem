package by.softclub.depositservice.controller;

import by.softclub.depositservice.dto.DepositCreateRequest;
import by.softclub.depositservice.dto.DepositOperationRequest;
import by.softclub.depositservice.entity.AgreementStatus;
import by.softclub.depositservice.entity.Deposit;
import by.softclub.depositservice.service.DepositService;
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
@RequestMapping("/api/deposits")
@Tag(name="Deposits", description = "API for managing deposit agreements")
@SecurityRequirement(name="basicAuth")
public class DepositController {
    private final DepositService depositService;

    public DepositController(DepositService depositService) {this.depositService = depositService;}

    @Operation(
            summary = "Create",
            description = "Создает новый договор депозита с шаблонными или особыми условиями"
    )
    @PostMapping("/new")
    public ResponseEntity<Deposit> createDeposit(@Valid @RequestBody DepositCreateRequest request) {
        return ResponseEntity.ok(depositService.createDeposit(request));
    }

    @Operation(
            summary = "Read",
            description = "Возвращает депозиты с использованием кучи фильтров"
    )
    @GetMapping
    public ResponseEntity<List<Deposit>> getDeposits(
            @RequestParam(required = false) Long clientId,
            @RequestParam(required = false) String agreementCode,
            @RequestParam(required = false) String agreementType,
            @RequestParam(required = false) Double amountFrom,
            @RequestParam(required = false) Double amountTo,
            @RequestParam(required = false) Float interestRateFrom,
            @RequestParam(required = false) Float interestRateTo,
            @RequestParam(required = false) Integer durationFrom,
            @RequestParam(required = false) Integer durationTo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate signDateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate signDateTo,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDateTo,
            @RequestParam(required = false) AgreementStatus status,
            @RequestParam(required = false) Boolean replenishment,
            @RequestParam(required = false) Boolean withdrawal,
            @RequestParam(required = false) Double minBalanceFrom,
            @RequestParam(required = false) Double minBalanceTo,
            @RequestParam(required = false) Integer paymentFrequencyFrom,
            @RequestParam(required = false) Integer paymentFrequencyTo,
            @RequestParam(defaultValue = "agreementCode") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection
            ) {
        return ResponseEntity.ok(depositService.getDeposits(clientId,
                agreementCode, agreementType, amountFrom, amountTo,
                interestRateFrom, interestRateTo, durationFrom, durationTo,
                signDateFrom, signDateTo, endDateFrom, endDateTo, status,
                replenishment, withdrawal, minBalanceFrom, minBalanceTo,
                paymentFrequencyFrom, paymentFrequencyTo, sortBy, sortDirection));
    }

    @Operation(
            summary = "Update",
            description = "Совершает над депозитом переданную операцию"
    )
    @PostMapping("/update")
    public ResponseEntity<Deposit> depositOperation(@Valid @RequestBody DepositOperationRequest request) {
        return ResponseEntity.ok(depositService.depositOperation(request));
    }

    @Operation(
            summary = "Delete",
            description = "Удаляет депозит если его статус CLOSED"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDeposit(@PathVariable long id) {
        depositService.deleteDeposit(id);
        return ResponseEntity.ok().build();
    }
}
