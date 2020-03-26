package com.bank.springbank.service;

import com.bank.springbank.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAllClients();

    Client newClient(Client client);

    List<Client> findByKeyword(String keyword);

}
