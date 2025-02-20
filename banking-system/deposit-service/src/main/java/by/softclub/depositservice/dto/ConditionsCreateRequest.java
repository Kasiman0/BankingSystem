package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ConditionsCreateRequest {

    @NotEmpty
    @Size(max = 10)
    private String agreementType;

    @NotNull
    private Boolean replenishment;

    @NotNull
    private Boolean withdrawal;

    @NotNull
    private Double minBalance;

    @NotNull
    private Integer paymentFrequency;

    public String getAgreementType() {return agreementType;}

    public Boolean isReplenishment() {return replenishment;}

    public Boolean isWithdrawal() {return withdrawal;}

    public Double getMinBalance() {return minBalance;}

    public Integer getPaymentFrequency() {return paymentFrequency;}
}
