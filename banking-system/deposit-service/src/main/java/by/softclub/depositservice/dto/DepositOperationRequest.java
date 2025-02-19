package by.softclub.depositservice.dto;

import by.softclub.depositservice.entity.Operations;
import jakarta.validation.constraints.NotEmpty;

public class DepositOperationRequest {

    @NotEmpty
    private long id;

    @NotEmpty
    private Operations operation;

    private Double sum;

    public long getId() { return id; }

    public Operations getOperation() { return operation; }

    public Double getSum() { return sum; }
}
