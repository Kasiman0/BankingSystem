package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DepositCreateRequest {

    @NotNull
    private Long clientId;

    @NotEmpty
    @Size(max = 10)
    private String agreementCode;

    @NotEmpty
    @Size(max = 10)
    private String agreementType;

    @NotNull
    private Double amount;

    @NotNull
    private Float interestRate;

    @NotNull
    private Integer duration;

    private Boolean replenishment;
    private Boolean withdrawal;
    private Double minBalance;
    private Integer paymentFrequency;

    public Long getClientId() {return clientId;}

    public String getAgreementCode() {return agreementCode;}

    public String getAgreementType() {return agreementType;}

    public Double getAmount() {return amount;}

    public Float getInterestRate() {return interestRate;}

    public Integer getDuration() {return duration;}

    public Boolean getReplenishment() {return replenishment;}

    public Boolean getWithdrawal() {return withdrawal;}

    public Double getMinBalance() {return minBalance;}

    public Integer getPaymentFrequency() {return paymentFrequency;}
}
