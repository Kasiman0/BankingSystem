package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DepositCreateRequest {

    @NotEmpty
    private long clientId;

    @NotEmpty
    @Size(max = 10)
    private String agreementCode;

    @NotEmpty
    @Size(max = 10)
    private String agreementType;

    @NotEmpty
    private double amount;

    @NotEmpty
    private float interestRate;

    @NotEmpty
    private int duration;

    private boolean replenishment;
    private boolean withdrawal;
    private double minBalance;
    private int paymentFrequency;

    public long getClientId() {return clientId;}

    public String getAgreementCode() {return agreementCode;}

    public String getAgreementType() {return agreementType;}

    public double getAmount() {return amount;}

    public float getInterestRate() {return interestRate;}

    public int getDuration() {return duration;}

    public boolean isReplenishment() {return replenishment;}

    public boolean isWithdrawal() {return withdrawal;}

    public double getMinBalance() {return minBalance;}

    public int getPaymentFrequency() {return paymentFrequency;}
}
