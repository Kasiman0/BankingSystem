package by.softclub.depositservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="agreement_conditions")
public class Conditions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="agreement_type", length=10)
    private String agreementType;

    @Column
    private boolean replenishment;

    @Column
    private boolean withdrawal;

    @Column(name="minimal_balance")
    private float minBalance;

    @Column(name="payment_frequency")
    private int paymentFrequency;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getAgreementType() {return agreementType;}
    public void setAgreementType(String agreementType) {this.agreementType = agreementType;}

    public boolean isReplenishment() {return replenishment;}
    public void setReplenishment(boolean replenishment) {this.replenishment = replenishment;}

    public boolean isWithdrawal() {return withdrawal;}
    public void setWithdrawal(boolean withdrawal) {this.withdrawal = withdrawal;}

    public float getMinBalance() {return minBalance;}
    public void setMinBalance(float minBalance) {this.minBalance = minBalance;}

    public int getPaymentFrequency() {return paymentFrequency;}
    public void setPaymentFrequency(int paymentFrequency) {this.paymentFrequency = paymentFrequency;}
}
