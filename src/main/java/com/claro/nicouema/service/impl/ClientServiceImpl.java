package com.claro.nicouema.service.impl;

import com.claro.nicouema.mappers.ClientMapper;
import com.claro.nicouema.model.Client;
import com.claro.nicouema.model.User;
import com.claro.nicouema.persistence.ClientRepository;
import com.claro.nicouema.requests.CreateClientRequest;
import com.claro.nicouema.response.ClientResponse;
import com.claro.nicouema.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    public Long createClient(CreateClientRequest request, User user) {
        Client client = mapper.createClientRequestToClient(request);
        client.setUser(user);
        return repository.saveClient(client);
    }

    @Override
    public ClientResponse getClientById(Long id) {
        Client client = repository.getClientById(id);

        return mapper.clientToClientResponse(client);
    }
}
