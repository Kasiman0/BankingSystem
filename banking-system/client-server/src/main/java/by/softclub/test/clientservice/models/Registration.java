package by.softclub.test.clientservice.models;

import jakarta.persistence.*;
import lombok.Data;

@Data//@Table(name="registrations")
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "zip")
    private int zip;
    @Column(name = "region")
    private String region;
    @Column(name = "city")
    private String city;
    @Column(name = "houseFlatName")
    private String houseFlatName;
}
