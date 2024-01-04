package com.claro.nicouema.controller.apis;

import com.claro.nicouema.model.User;
import com.claro.nicouema.requests.CreateClientRequest;
import com.claro.nicouema.response.ClientResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "bearerAuth")
public interface ClientApi {

    ResponseEntity<Void> createClient(CreateClientRequest clientRequest, User user);

    ResponseEntity<ClientResponse> getClientById(Long id);
}
