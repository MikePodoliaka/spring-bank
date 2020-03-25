package com.bank.springbank.service.impl;

import com.bank.springbank.entity.Account;
import com.bank.springbank.entity.Client;
import com.bank.springbank.repository.AccountRepository;
import com.bank.springbank.repository.ClientRepository;
import com.bank.springbank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Account> clientAccounts(Long id) {

        return clientRepository.findById(id).get().getClientAccounts();
    }

    @Override
    public BigDecimal moneyOfAllAccounts(Long id) {
        return null;
    }

    @Override
    public Account newAccount(Long clientId) {
        Random random=new Random();
        Long numberAcc=random.nextLong();


        Account account = new Account();
        Client currentClient = clientRepository.findById(clientId).get();
        List<Account> list =currentClient.getClientAccounts();
        account.setAccountBalance(BigDecimal.ZERO);
        account.setClient(currentClient);
        account.setAccountNumber(numberAcc);
        accountRepository.save(account);
        list.add(account);
        currentClient.setClientAccounts(list);
        clientRepository.save(currentClient);
        return account;
    }
}
