package by.softclub.test.clientservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationDto {
    private Long id;
    private String city;
    private String houseFlatName;
    private String region;
    private Integer zip;
}
