package by.softclub.depositservice.service;

import by.softclub.depositservice.dto.DepositCreateRequest;
import by.softclub.depositservice.entity.Deposit;
import by.softclub.depositservice.repository.DepositRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    private final DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {this.depositRepository = depositRepository;}

    @Transactional
    public Deposit createDeposit(DepositCreateRequest request) {
        Deposit deposit = new Deposit();

        return deposit;
    }
}
