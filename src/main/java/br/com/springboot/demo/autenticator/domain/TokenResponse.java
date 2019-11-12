package br.com.springboot.demo.autenticator.domain;

import lombok.Builder;

@Builder
public class TokenResponse {

    private String token;
    private String type;

}
