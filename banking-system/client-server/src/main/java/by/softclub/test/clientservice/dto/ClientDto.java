package by.softclub.test.clientservice.dto;

import java.time.LocalDate;

import by.softclub.test.clientservice.models.Statuses;
import lombok.*;


@Data
public class ClientDto {
    private Long   id;
    private String username;
    private String telephone;
    private String email;
    private LocalDate dateLast;
    private Statuses status;
}
