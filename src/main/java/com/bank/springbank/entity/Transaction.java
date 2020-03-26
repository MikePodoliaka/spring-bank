package com.bank.springbank.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long receiveAcc;
    private Long senderAcc;
    private String senderName;
    private LocalDateTime dateOfTransaction;
    private String description;
    private BigDecimal amount;
}
