package by.softclub.depositservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="client_id")
    private Long clientId;

    @Column(name="agreement_code", length=10, nullable=false)
    private String agreementCode;

    @Column(name="agreement_type", length=10)
    private String agreementType;

    @Column(name="amount", nullable=false)
    private Double amount;

    @Column(name="interest_rate", nullable=false)
    private Float interestRate;

    @Column(name="duration")
    private Integer duration;

    @Column(name="sign_date")
    private LocalDate signDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    private AgreementStatus status;

    @Column(name="replenishment")
    private Boolean replenishment;

    @Column(name="withdrawal")
    private Boolean withdrawal;

    @Column(name="min_balance")
    private Double minBalance;

    @Column(name="payment_frequency")
    private Integer paymentFrequency;

    public long getId() {return id;}

    public Long getClientId() {return clientId;}
    public void setClientId(Long clientId) {this.clientId = clientId;}

    public String getAgreementCode() {return agreementCode;}
    public void setAgreementCode(String agreementCode) {this.agreementCode = agreementCode;}

    public String getAgreementType() {return agreementType;}
    public void setAgreementType(String agreementType) {this.agreementType = agreementType;}

    public Double getAmount() {return amount;}
    public void setAmount(Double amount) {this.amount = amount;}

    public Float getInterestRate() {return interestRate;}
    public void setInterestRate(Float interestRate) {this.interestRate = interestRate;}

    public Integer getDuration() {return duration;}
    public void setDuration(Integer duration) {this.duration = duration;}

    public LocalDate getSignDate() {return signDate;}
    public void setSignDate(LocalDate signDate) {this.signDate = signDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public AgreementStatus getStatus() {return status;}
    public void setStatus(AgreementStatus status) {this.status = status;}

    public Boolean getReplenishment() {return replenishment;}
    public void setReplenishment(Boolean replenishment) {this.replenishment = replenishment;}

    public Boolean getWithdrawal() {return withdrawal;}
    public void setWithdrawal(Boolean withdrawal) {this.withdrawal = withdrawal;}

    public Double getMinBalance() {return minBalance;}
    public void setMinBalance(Double minBalance) {this.minBalance = minBalance;}

    public Integer getPaymentFrequency() {return paymentFrequency;}
    public void setPaymentFrequency(Integer paymentFrequency) {this.paymentFrequency = paymentFrequency;}
}
