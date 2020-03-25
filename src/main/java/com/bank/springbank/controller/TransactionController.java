package com.bank.springbank.controller;

import com.bank.springbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transfer")
    public String transactionsList(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("transactions", transactionService.findByKeyword(keyword));
        } else {
            model.addAttribute("transactions", transactionService.transactionsList());
        }

        return "transactions";
    }

    @Transactional
    @PostMapping(value = "/transferMoney")
    public String transferMoney(@RequestParam(name = "sender_account") Long senderAcc,
                                @RequestParam(name = "receive_account") Long receiveAcc,
                                @RequestParam(name = "transfer_amount") BigDecimal amount,
                                @RequestParam(name = "transaction_description") String transactionDescription,
                                @RequestParam(name = "sender_name") String senderName)
            throws Exception {
        transactionService.moneyTransfer(senderAcc, receiveAcc, amount, transactionDescription, senderName);
        transactionService.withdrawMoney(senderAcc, amount);
        transactionService.depositMoney(receiveAcc, amount);
        return "redirect:/transfer";
    }
}
