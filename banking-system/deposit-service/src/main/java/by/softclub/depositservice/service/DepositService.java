package by.softclub.depositservice.service;

import by.softclub.depositservice.repository.DepositRepository;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    private final DepositRepository depositRepository;

    public DepositService(DepositRepository depositRepository) {this.depositRepository = depositRepository;}
}
