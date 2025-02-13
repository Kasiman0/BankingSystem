package by.softclub.test.clientservice.controllers;


import by.softclub.test.clientservice.dto.ClientDto;
import by.softclub.test.clientservice.models.Registration;
import by.softclub.test.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;


@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

   @PostMapping(value = "/check_login")
    public String checkLogin(@RequestParam String email,
                             @RequestParam String telephone, Model model) {


       return "about"; }

    // Вывод на экран всех клиентов
    @GetMapping(value = "/clients")
    public String clients(Model model) {
        Iterable<ClientDto> clientDto = clientService.readAll();
        model.addAttribute("Client", clientDto);
        return "clients/listClient";
    }


    //  Вызов формы для ввода пользователя
    @GetMapping(value = "/add_client")
    public String addClient(Model model) {
        model.addAttribute("title", "Добавить пользователя");
        return "clients/addClient";
    }

    //  Обработка формы ввода пользователя
    @PostMapping(value = "/add_client")
    public String addClient(@RequestParam String email,
                            @RequestParam String username,
                            @RequestParam String telephone,
                            @RequestParam LocalDate birthDate,
                            //@RequestParam String passport_id,
                           // @RequestParam Registration registration,
                            Model model) {
            clientService.addClient(email, username, telephone, birthDate);
        return "redirect:/";
    }

    //  Удаление пользователя
    @GetMapping(value = "/{id}/remove")
    public String RemoveUser(@PathVariable(value = "id") long id, Model model) {

        clientService.deleteId(id);
        return "redirect:/";
    }
}
