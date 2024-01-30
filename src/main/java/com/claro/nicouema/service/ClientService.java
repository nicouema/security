package com.claro.nicouema.service;

import com.claro.nicouema.model.User;
import com.claro.nicouema.requests.CreateClientRequest;
import com.claro.nicouema.response.ClientResponse;

public interface ClientService {

    Long createClient(CreateClientRequest request, User user);

    ClientResponse getClientById(Long id);
}
