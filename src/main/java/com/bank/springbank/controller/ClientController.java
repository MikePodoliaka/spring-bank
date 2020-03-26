package com.bank.springbank.controller;

import com.bank.springbank.entity.Client;
import com.bank.springbank.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients")
    public String getAllClients(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("clients", clientService.findByKeyword(keyword));
        } else {
            model.addAttribute("clients", clientService.findAllClients());
        }
        return "clients";
    }

    @PostMapping(value = "/newClient")
    public String newClient(@RequestParam(name = "client_firstName") String firstName,
                            @RequestParam(name = "client_lastName") String lastName,
                            @RequestParam(name = "client_address") String address,
                            @RequestParam(name = "client_age") short age) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAddress(address);
        client.setAge(age);
        clientService.newClient(client);
        return "redirect:/clients";
    }
}
