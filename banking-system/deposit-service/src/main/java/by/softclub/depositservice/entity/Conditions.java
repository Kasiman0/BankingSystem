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
    private Boolean replenishment;

    @Column
    private Boolean withdrawal;

    @Column(name="min_balance")
    private Double minBalance;

    @Column(name="payment_frequency")
    private Integer paymentFrequency;

    public int getId() {return id;}

    public String getAgreementType() {return agreementType;}
    public void setAgreementType(String agreementType) {this.agreementType = agreementType;}

    public Boolean getReplenishment() {return replenishment;}
    public void setReplenishment(Boolean replenishment) {this.replenishment = replenishment;}

    public Boolean getWithdrawal() {return withdrawal;}
    public void setWithdrawal(Boolean withdrawal) {this.withdrawal = withdrawal;}

    public Double getMinBalance() {return minBalance;}
    public void setMinBalance(Double minBalance) {this.minBalance = minBalance;}

    public Integer getPaymentFrequency() {return paymentFrequency;}
    public void setPaymentFrequency(Integer paymentFrequency) {this.paymentFrequency = paymentFrequency;}
}
