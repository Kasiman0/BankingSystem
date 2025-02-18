package by.softclub.depositservice.controller;

import by.softclub.depositservice.dto.ConditionsCreateRequest;
import by.softclub.depositservice.dto.ConditionsUpdateRequest;
import by.softclub.depositservice.entity.Conditions;
import by.softclub.depositservice.service.ConditionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/depositConditions")
@Tag(name="DepositConditions", description = "API for managing conditions of typical deposit agreements")
@SecurityRequirement(name="basicAuth")
public class ConditionsController {

    private final ConditionsService conditionsService;

    public ConditionsController(ConditionsService conditionsService) {this.conditionsService = conditionsService;}

    @Operation(
            summary = "Create",
            description = "Создает новый шаблон условий договора в БД"
    )
    @PostMapping("/new")
    public ResponseEntity<Conditions> newConditions(@Valid @RequestBody ConditionsCreateRequest request) {
        return ResponseEntity.ok(conditionsService.createConditions(request));
    }

    @Operation(
            summary = "Read",
            description = "Находим в таблице шаблонов записи с указанными параметрами"
    )
    @GetMapping
    public ResponseEntity<List<Conditions>> getConditions(
            @RequestParam(required = false) String agreementType,
            @RequestParam(required = false) Boolean replenishment,
            @RequestParam(required = false) Boolean withdrawal,
            @RequestParam(required = false) Float minBalanceFrom,
            @RequestParam(required = false) Float minBalanceTo,
            @RequestParam(required = false) Integer paymentFrequencyFrom,
            @RequestParam(required = false) Integer paymentFrequencyTo,
            @RequestParam(defaultValue = "agreementType") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection
    ) {
        return ResponseEntity.ok(conditionsService.getConditions(agreementType, replenishment, withdrawal,
                minBalanceFrom, minBalanceTo, paymentFrequencyFrom, paymentFrequencyTo, sortBy, sortDirection));
    }

    @Operation(
            summary = "Update",
            description = "Обновляет запись в таблице по id, изменяя указанные поля"
    )
    @PostMapping
    public ResponseEntity<Conditions> updateConditions(@Valid @RequestBody ConditionsUpdateRequest request) {
        return ResponseEntity.ok(conditionsService.updateConditions(request));
    }

    @Operation(
            summary = "Delete",
            description = "Удаляет запись по id"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConditions(@PathVariable int id) {
        conditionsService.deleteConditions(id);
        return ResponseEntity.ok().build();
    }
}
