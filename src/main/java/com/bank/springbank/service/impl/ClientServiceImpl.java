package com.bank.springbank.service.impl;

import com.bank.springbank.entity.Client;
import com.bank.springbank.repository.ClientRepository;
import com.bank.springbank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client newClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findByKeyword(String keyword) {
        return clientRepository.findByKeyword(keyword);
    }
}
