package by.softclub.test.clientservice.utils;

import by.softclub.test.clientservice.dto.PassportDto;
import by.softclub.test.clientservice.models.Passport;
import org.springframework.stereotype.Service;

@Service
public class PassportMapper {

    public static PassportDto mapToPassportDto(Passport passport)
    {
        //TODO check
        PassportDto dto = new PassportDto();
        dto.setId(passport.getId());
        dto.setNumber(passport.getNumber());
        dto.setIssueDate(passport.getIssueDate());
        dto.setByWhomIssued(passport.getByWhomIssued());
        dto.setUnitCode(passport.getUnitCode());
        return dto;
    }

    public Passport mapToPassport(PassportDto dto)
    {
//TODO check
        Passport passport=new Passport();
        passport.setId(dto.getId());
        passport.setNumber(dto.getNumber());
        passport.setIssueDate(dto.getIssueDate());
        passport.setByWhomIssued(dto.getByWhomIssued());
        passport.setUnitCode(dto.getUnitCode());
        return passport;
    }


}