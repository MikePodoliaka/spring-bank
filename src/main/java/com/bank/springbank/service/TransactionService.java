package com.bank.springbank.service;

import com.bank.springbank.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {
    List<Transaction> transactionsList();

    void moneyTransfer(Long senderAcc, Long receiveAcc,
                       BigDecimal amount, String description, String senderName) throws Exception;

    void depositMoney(Long accountNumber, BigDecimal amount) throws Exception;

    void withdrawMoney(Long accountNumber, BigDecimal amount) throws Exception;

    List<Transaction> findByKeyword(String keyword);


}
