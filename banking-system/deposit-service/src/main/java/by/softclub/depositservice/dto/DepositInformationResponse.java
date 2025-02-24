package by.softclub.depositservice.dto;

import by.softclub.depositservice.entity.Deposit;
import by.softclub.depositservice.entity.OperationHistory;

import java.util.List;

public class DepositInformationResponse {
    private Deposit deposit;

    private Object client;

    private List<OperationHistory> history;

    public DepositInformationResponse(Deposit deposit, Object client, List<OperationHistory> history) {
        this.deposit = deposit;
        this.client = client;
        this.history = history;
    }

    public Deposit getDeposit() { return deposit; }

    public Object getClient() { return client; }

    public List<OperationHistory> getHistory() { return history; }
}
