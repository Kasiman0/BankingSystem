package by.softclub.depositservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="client_id")
    private long clientId;

    @Column(name="agreement_code", length=10, nullable=false)
    private String agreementCode;

    @Column(name="agreement_type", length=10)
    private String agreementType;

    @Column(name="amount", nullable=false)
    private double amount;

    @Column(name="interest_rate", nullable=false)
    private float interestRate;

    @Column(name="duration")
    private int duration;

    @Column(name="sign_date")
    private LocalDate signDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    private AgreementStatus status;

    @Column(name="replenishment")
    private boolean replenishment;

    @Column(name="withdrawal")
    private boolean withdrawal;

    @Column(name="minimal_balance")
    private double minBalance;

    @Column(name="payment_frequency")
    private int paymentFrequency;
}
