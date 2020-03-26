package com.bank.springbank.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private Long accountNumber;
    private BigDecimal accountBalance;
    @ManyToOne
    private Client client;
}
