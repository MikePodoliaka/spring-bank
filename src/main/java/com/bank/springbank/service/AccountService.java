package com.bank.springbank.service;

import com.bank.springbank.entity.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    List<Account> clientAccounts(Long id);

    BigDecimal moneyOfAllAccounts(Long id);

    Account newAccount(Long clientId);

}
