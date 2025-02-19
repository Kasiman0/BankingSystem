package by.softclub.test.clientservice.dto;

import by.softclub.test.clientservice.models.Statuses;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PassportDto {
    private Long   id;
    private String SeriesAndNumber;
    private LocalDate issueDate;
    private String byWhomIssued;
    private String unitCode;

}
