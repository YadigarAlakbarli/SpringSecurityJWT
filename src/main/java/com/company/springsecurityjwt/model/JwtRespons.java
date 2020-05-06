package com.company.springsecurityjwt.model;

public class JwtRespons {
    private final String jwt;

    public JwtRespons(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
