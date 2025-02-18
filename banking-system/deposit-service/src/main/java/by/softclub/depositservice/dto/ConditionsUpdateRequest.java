package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotNull;

public class ConditionsUpdateRequest {

    @NotNull
    private int id;

    private Boolean replenishment;

    private Boolean withdrawal;

    private Float minBalance;

    private Integer paymentFrequency;


    public int getId() { return id; }

    public Boolean getReplenishment() { return replenishment; }

    public Boolean getWithdrawal() { return withdrawal; }

    public Float getMinBalance() { return minBalance; }

    public Integer getPaymentFrequency() { return paymentFrequency; }
}
