package by.softclub.test.clientservice.controllers;

import by.softclub.test.clientservice.dto.ClientDto;
import by.softclub.test.clientservice.dto.PassportDto;
import by.softclub.test.clientservice.service.ClientService;
import by.softclub.test.clientservice.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class PassportController {

    @Autowired
    private PassportService passportService;

    @GetMapping(value = "/passports")
    public String passports(Model model) {
        Iterable<PassportDto> PassportDto = passportService.readAll();
        model.addAttribute("Passport", PassportDto);
        return "passports/listPassports";
    }

    //  Вызов формы для ввода пользователя
    @GetMapping(value = "/add_passport")
    public String addPassport(Model model) {
        model.addAttribute("title", "Добавить пасспорт");
        return "addPassport";
    }

    @PostMapping(value = "/add_passport")
    public String addPassport(@RequestParam String SeriesAndNumber,
                              @RequestParam String byWhomIssued,
                              @RequestParam LocalDate issueDate,
                              @RequestParam String unitCode,
                              Model model) {
        passportService.addPassport(SeriesAndNumber, byWhomIssued, issueDate, unitCode);
        return "redirect:/";
    }
}