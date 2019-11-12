package br.com.springboot.demo.autenticator.controller;

import br.com.springboot.demo.autenticator.config.secutiry.TokenService;
import br.com.springboot.demo.autenticator.domain.TokenResponse;
import br.com.springboot.demo.autenticator.domain.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity authentication(@RequestBody @Valid UserRequest userRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword())
        );

        String token = tokenService.createToken(authentication);

        return ResponseEntity.ok(TokenResponse.builder()
                .token(token)
                .type("Bearer")
                .build());
    }
}
