package by.softclub.test.clientservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Change_history")
public class ChangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable=false)
    private ChangeType type;

    @Column(name="client_id", nullable=false)
    private Long clientId;

    @Column(name="column_name", length = 20)
    private String columnName;

    @Column(name="old_value", length = 100)
    private String oldValue;

    @Column(name="new_value", length = 100)
    private String newValue;

    @Column(name="change_date", nullable=false)
    private LocalDate changeDate;

    public ChangeType getType() { return type; }
    public void setType(ChangeType type) { this.type = type; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public String getColumnName() { return columnName; }
    public void setColumnName(String columnName) { this.columnName = columnName; }

    public String getOldValue() { return oldValue; }
    public void setOldValue(String oldValue) { this.oldValue = oldValue; }

    public String getNewValue() { return newValue; }
    public void setNewValue(String newValue) { this.newValue = newValue; }

    public LocalDate getChangeDate() { return changeDate; }
    public void setChangeDate(LocalDate changeDate) { this.changeDate = changeDate; }
}
