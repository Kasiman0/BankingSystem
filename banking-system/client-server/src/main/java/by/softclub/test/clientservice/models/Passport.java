package by.softclub.test.clientservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="passport")
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "series_and_number")
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "by_whom_issued")
    private String byWhomIssued;
    @Column(name = "unit_code")
    private String unitCode;
}
