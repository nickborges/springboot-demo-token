package br.com.springboot.demo.autenticator.domain;

import lombok.Getter;

@Getter
public class UserRequest {

    private String email;
    private String password;

}
