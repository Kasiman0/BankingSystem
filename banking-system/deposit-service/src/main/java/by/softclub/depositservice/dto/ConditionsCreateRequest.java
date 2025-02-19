package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ConditionsCreateRequest {

    @NotEmpty
    @Size(max = 10)
    private String agreementType;

    @NotEmpty
    private Boolean replenishment;

    @NotEmpty
    private Boolean withdrawal;

    @NotEmpty
    private Double minBalance;

    @NotEmpty
    private Integer paymentFrequency;

    public String getAgreementType() {return agreementType;}

    public Boolean isReplenishment() {return replenishment;}

    public Boolean isWithdrawal() {return withdrawal;}

    public Double getMinBalance() {return minBalance;}

    public Integer getPaymentFrequency() {return paymentFrequency;}
}
