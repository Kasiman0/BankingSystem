package by.softclub.depositservice.controller;

import by.softclub.depositservice.service.DepositService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deposits")
@Tag(name="Deposits", description = "API for managing deposit agreements")
@SecurityRequirement(name="basicAuth")
public class DepositController {
    private final DepositService depositService;

    public DepositController(DepositService depositService) {this.depositService = depositService;}
}
