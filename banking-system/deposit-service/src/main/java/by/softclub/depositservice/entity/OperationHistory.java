package by.softclub.depositservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "operation_history")
public class OperationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "deposit_id", nullable = false)
    private long depositId;

    @Enumerated(EnumType.STRING)
    @Column(name = "change_type", length = 1, nullable = false)
    private ChangeType changeType;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 1)
    private Operations operation;

    @Column(name = "sum")
    private double sum;

    @Column(name = "new_balance")
    private double newBalance;

    @Column(name = "operation_date")
    private LocalDate operationDate;

    public long getId() { return id; }

    public long getDepositId() { return depositId; }
    public void setDepositId(long depositId) { this.depositId = depositId; }

    public ChangeType getChangeType() { return changeType; }
    public void setChangeType(ChangeType changeType) { this.changeType = changeType; }

    public Operations getOperation() { return operation; }
    public void setOperation(Operations operation) { this.operation = operation; }

    public double getSum() { return sum; }
    public void setSum(double sum) { this.sum = sum; }

    public double getNewBalance() { return newBalance; }
    public void setNewBalance(double newBalance) { this.newBalance = newBalance; }

    public LocalDate getOperationDate() { return operationDate; }
    public void setOperationDate(LocalDate operationDate) { this.operationDate = operationDate; }
}
