package com.claro.nicouema.controller;

import com.claro.nicouema.controller.apis.AuthenticationApi;
import com.claro.nicouema.model.User;
import com.claro.nicouema.requests.AuthenticationRequest;
import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.AuthenticationResponse;
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

import static com.claro.nicouema.controller.apis.ApiConstants.Paths.AUTH;
import static com.claro.nicouema.controller.apis.ApiConstants.Paths.LOGIN;
import static com.claro.nicouema.controller.apis.ApiConstants.Paths.REGISTER;


@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController implements AuthenticationApi {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping(LOGIN)
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody AuthenticationRequest request) {

        log.info(":::::: Logging in user: {} ::::::", request.getUsername());
        AuthenticationResponse response = authenticationService
                .prepareAuthenticationResponse(request.getUsername(),
                        request.getPassword());

        log.info(":::::: User {} logged in ::::::", request.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping(REGISTER)
    public ResponseEntity<Object> registerUser(@RequestBody CreateUserRequest userRequest) {
        User createdUser = userService.registerUser(userRequest);


        AuthenticationResponse authenticationResponse = authenticationService
                .prepareAuthenticationResponse(userRequest.getUsername(),
                        userRequest.getPassword());

        var response = authenticationService
                .prepareAuthentication(createdUser, authenticationResponse);



        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{username}").buildAndExpand(createdUser.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> getTest(){
        return ResponseEntity.ok("Test");
    }

    @GetMapping("/test-2")
    public ResponseEntity<Object> getTest2() {
        return ResponseEntity.ok("Test 2");
    }

}
