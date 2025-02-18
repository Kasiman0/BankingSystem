package by.softclub.depositservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ConditionsCreateRequest {

    @NotEmpty
    @Size(max = 10)
    private String agreementType;

    @NotEmpty
    private boolean replenishment;

    @NotEmpty
    private boolean withdrawal;

    @NotEmpty
    private float minBalance;

    @NotEmpty
    private int paymentFrequency;

    public String getAgreementType() {return agreementType;}

    public boolean isReplenishment() {return replenishment;}

    public boolean isWithdrawal() {return withdrawal;}

    public float getMinBalance() {return minBalance;}

    public int getPaymentFrequency() {return paymentFrequency;}
}
