package by.softclub.test.clientservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data//@Table(name="passports")
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "series_and_number")
    private String SeriesAndNumber;
    @Column(name = "issue_data")
    private LocalDate issueData;
    @Column(name = "by_whom_issued")
    private String byWhomIssued;
    @Column(name = "unit_code")
    private String unitCode;
}
