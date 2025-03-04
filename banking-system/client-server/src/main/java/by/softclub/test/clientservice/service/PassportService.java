package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.dto.PassportDto;
import by.softclub.test.clientservice.models.Passport;
import by.softclub.test.clientservice.repo.PassportRepository;
import by.softclub.test.clientservice.utils.PassportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private PassportMapper passportMapper;
    private String number;
    private String byWhomIssued;
    private LocalDate issueDate;
    private String unitCode;


    public List<PassportDto> readAll() {
        List<Passport> passports = passportRepository.findAll();
        return passports.stream()
                .map(PassportMapper::mapToPassportDto)
                .collect(Collectors.toList());
    }

    public Passport getByNumber(String number) {
        Passport passport = passportRepository.findByNumber(number);
        return passport;
    }


    public void addPassport() {
        addPassport((String) null, (String) null, (LocalDate) null, (String) null);
    }

    public void addPassport(String number, String byWhomIssued, LocalDate issueDate, String unitCode) {
        this.number = number;
        this.byWhomIssued = byWhomIssued;
        this.issueDate = issueDate;
        this.unitCode = unitCode;
        ZoneId zone = ZoneId.of("Europe/Minsk");
        LocalDate today = LocalDate.now(zone);
        Passport passport = new Passport();
        passport.setNumber(number);
        passport.setByWhomIssued(byWhomIssued);
        passport.setIssueDate(issueDate);
        passport.setUnitCode(unitCode);
        passportRepository.save(passport);
    }
}