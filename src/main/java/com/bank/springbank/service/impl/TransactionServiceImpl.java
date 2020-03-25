package com.bank.springbank.service.impl;

import com.bank.springbank.entity.Account;
import com.bank.springbank.entity.Transaction;
import com.bank.springbank.repository.AccountRepository;
import com.bank.springbank.repository.TransactionRepository;
import com.bank.springbank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Transaction> transactionsList() {

        return transactionRepository.findAll();
    }

    @Override
    public void moneyTransfer(Long senderAcc, Long receiveAcc, BigDecimal amount, String description, String senderName) {
        Transaction transaction = new Transaction();
        transaction.setReceiveAcc(receiveAcc);
        transaction.setSenderAcc(senderAcc);
        transaction.setDateOfTransaction(LocalDateTime.now());
        transaction.setDescription(description);
        transaction.setAmount(amount);
        transaction.setSenderName(senderName);
        transactionRepository.save(transaction);
    }

    @Override
    public void depositMoney(Long id, BigDecimal amount) throws Exception {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new Exception("Can't find account with id " + id));
        BigDecimal currentBalance = account.getAccountBalance().add(amount);
        account.setAccountBalance(currentBalance);
        accountRepository.save(account);
    }

    @Override
    public void withdrawMoney(Long id, BigDecimal amount) throws Exception {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new Exception("Can't find account with id " + id));
        BigDecimal currentBalance = account.getAccountBalance();
        if (currentBalance.compareTo(amount) < 0) {
            throw new Exception("Invalid operation");
        }
        currentBalance = currentBalance.subtract(amount);
        account.setAccountBalance(currentBalance);
        accountRepository.save(account);
    }

    @Override
    public List<Transaction> findByKeyword(String keyword) {
        return transactionRepository.findByKeyword(keyword);
    }
}
