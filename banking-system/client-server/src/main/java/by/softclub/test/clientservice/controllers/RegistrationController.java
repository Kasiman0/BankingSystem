package by.softclub.test.clientservice.controllers;

import by.softclub.test.clientservice.dto.RegistrationDto;
import by.softclub.test.clientservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        Iterable<RegistrationDto> registrationDto = registrationService.readAll();
        model.addAttribute("Registration", registrationDto);
        return "registration/listRegistration";
    }

    @GetMapping(value = "/add_registration")
    public String addRegistration(Model model) {
        model.addAttribute("title", "Добавить регистрацию");
        return "registration/addRegistration";
    }

    @PostMapping(value = "/add_registration")
    public String addRegistration(@RequestParam String city,
                              @RequestParam String houseFlatName,
                              @RequestParam String region,
                              @RequestParam Integer zip,
                              Model model) {
        registrationService.addRegistration(city, houseFlatName, region, zip);
        return "redirect:/";
    }
}
