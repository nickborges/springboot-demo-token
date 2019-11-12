package br.com.springboot.demo.token.domain;

import lombok.Getter;

@Getter
public class UserRequest {

    private String email;
    private String password;

}
