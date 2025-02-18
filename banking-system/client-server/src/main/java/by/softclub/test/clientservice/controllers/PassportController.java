package by.softclub.test.clientservice.controllers;

import by.softclub.test.clientservice.dto.ClientDto;
import by.softclub.test.clientservice.service.ClientService;
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
    private ClientService passportService;

    //  Вызов формы для ввода пользователя
    @GetMapping(value = "/add_passport")
    public String addPassport(Model model) {
        model.addAttribute("title", "Добавить пасспорт");
        return "clients/addClient";
    }
}