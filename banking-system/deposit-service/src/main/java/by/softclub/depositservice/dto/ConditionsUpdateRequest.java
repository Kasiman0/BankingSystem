package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotNull;

public class ConditionsUpdateRequest {

    @NotNull
    private int id;

    private Boolean replenishment;

    private Boolean withdrawal;

    private Double minBalance;

    private Integer paymentFrequency;


    public int getId() { return id; }

    public Boolean getReplenishment() { return replenishment; }

    public Boolean getWithdrawal() { return withdrawal; }

    public Double getMinBalance() { return minBalance; }

    public Integer getPaymentFrequency() { return paymentFrequency; }
}
