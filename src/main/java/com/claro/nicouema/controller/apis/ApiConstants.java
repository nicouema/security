package com.claro.nicouema.controller.apis;


public final class ApiConstants {

    private ApiConstants() {}

    public interface Paths {
        String ADMIN = "/admin";
        String AUTH = "/auth";
        String LOGIN = "/login";
        String REGISTER = "/register";
    }

    public interface FullPaths extends Paths {
        String LOGIN_PATH = AUTH + LOGIN;
        String REGISTER_USER_PATH = AUTH + REGISTER;
    }
}
