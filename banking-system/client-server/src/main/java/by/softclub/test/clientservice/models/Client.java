package by.softclub.test.clientservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username") //Имя, Фамилия, Отчество
    private String username;

    @Column(name = "bday") //Дата рождения
    private LocalDate bday;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", nullable = false, columnDefinition = "ACTIVE")
    private Statuses status;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "passport_series_and_number")
    private String passportSeriesAndNumber;

}