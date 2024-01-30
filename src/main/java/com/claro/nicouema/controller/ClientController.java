package com.claro.nicouema.controller;

import com.claro.nicouema.controller.apis.ClientApi;
import com.claro.nicouema.model.Client;
import com.claro.nicouema.model.User;
import com.claro.nicouema.requests.CreateClientRequest;
import com.claro.nicouema.response.ClientResponse;
import com.claro.nicouema.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static com.claro.nicouema.controller.apis.ApiConstants.Paths.CLIENTS;

@RestController
@RequestMapping(CLIENTS)
@RequiredArgsConstructor
@Slf4j
public class ClientController implements ClientApi {

    private final ClientService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> createClient(@RequestBody CreateClientRequest clientRequest
            , @AuthenticationPrincipal User user) {
        log.info(":::::: saving client ::::::");
        Long client = service.createClient(clientRequest, user);
        log.info(":::::: client with id {} saved ::::::", client);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(client)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClientById(id));
    }


}
