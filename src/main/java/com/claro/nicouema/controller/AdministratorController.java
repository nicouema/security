package com.claro.nicouema.controller;

import com.claro.nicouema.controller.apis.AdminApi;
import com.claro.nicouema.model.User;
import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.AuthenticationResponse;
import com.claro.nicouema.response.UserAndAuthenticationResponse;
import com.claro.nicouema.response.UserResponse;
import com.claro.nicouema.service.AuthenticationService;
import com.claro.nicouema.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.claro.nicouema.controller.apis.AdminApi.ADMIN_URL;

@RestController
@RequestMapping(ADMIN_URL)
@RequiredArgsConstructor
@Slf4j
public class AdministratorController implements AdminApi {

    private final UserService service;
    private final AuthenticationService authenticationService;

    @Override
    @PostMapping
    public ResponseEntity<UserAndAuthenticationResponse> registerAdmin(@RequestBody CreateUserRequest createUserRequest) {
        User newAdmin = service.registerAdmin(createUserRequest);
        AuthenticationResponse authenticationResponse = authenticationService
                .prepareAuthenticationResponse(createUserRequest.getUsername(),
                        createUserRequest.getPassword());

        var response = authenticationService
                .prepareAuthentication(newAdmin, authenticationResponse);



        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{username}").buildAndExpand(newAdmin.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllAdmins() {
        return ResponseEntity.ok(service.getUsersOfRole("ADMIN"));
    }

}


