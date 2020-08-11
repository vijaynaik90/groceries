package com.iyengarcoders.groceries.security.payload;

public class JwtAuthenticationResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private String username;

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public JwtAuthenticationResponse(String accessToken, String username) {
        this.accessToken = accessToken;
        this.username = username;
    }
}
