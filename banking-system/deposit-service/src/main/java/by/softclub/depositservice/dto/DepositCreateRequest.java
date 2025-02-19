package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DepositCreateRequest {

    @NotEmpty
    private Long clientId;

    @NotEmpty
    @Size(max = 10)
    private String agreementCode;

    @NotEmpty
    @Size(max = 10)
    private String agreementType;

    @NotEmpty
    private Double amount;

    @NotEmpty
    private Float interestRate;

    @NotEmpty
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
