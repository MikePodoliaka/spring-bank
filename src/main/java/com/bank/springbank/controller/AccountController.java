package com.bank.springbank.controller;

import com.bank.springbank.entity.Account;
import com.bank.springbank.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/accounts")
    public String getAllAccOfClient(@RequestParam(name = "client_id") Long clientId, Model model) {
        List<Account> allAcc = accountService.clientAccounts(clientId);
        model.addAttribute("client_clientId", clientId);
        model.addAttribute("accounts", allAcc);
        return "accounts";
    }

    @RequestMapping(value = "/newAccount")
    public String newAccount(@RequestParam(name = "client_id") Long clientId, Model model) {
        model.addAttribute("client_clientId", clientId);
        accountService.newAccount(clientId);
        return "redirect:/clients";
    }
}
