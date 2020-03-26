package com.bank.springbank.service.impl;

import com.bank.springbank.entity.Client;
import com.bank.springbank.repository.ClientRepository;
import com.bank.springbank.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

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
