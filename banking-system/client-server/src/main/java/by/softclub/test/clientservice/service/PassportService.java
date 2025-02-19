package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.models.Passport;

import java.time.LocalDate;
import java.time.ZoneId;

public class PassportService {

    public void addPassport(String seriesAndNumber, LocalDate issueDate, String byWhomIssued, String unitCode) {
        addPassport((String) null, (LocalDate) null, (String) null, (String) null);
    }

    public void addPassport(String SeriesAndNumber, LocalDate issueDate, String byWhomIssued, String unitCode) {
        ZoneId zone = ZoneId.of("Europe/Minsk");
        LocalDate today = LocalDate.now(zone);
        Passport passport = new Passport();
        passport.setSeriesAndNumber(SeriesAndNumber);
        passport.setIssueDate(issueDate);
        passport.setByWhomIssued(byWhomIssued);
        passport.setUnitCode(unitCode);
    }
}