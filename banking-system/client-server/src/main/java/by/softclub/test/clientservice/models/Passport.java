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
    @Column(name = "SeriesAndNumber")
    private String SeriesAndNumber;
    @Column(name = "issueData")
    private LocalDate issueData;
    @Column(name = " byWhomIssued")
    private String byWhomIssued;
    @Column(name = "unitCode")
    private String unitCode;
}
