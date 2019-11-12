package br.com.springboot.demo.token.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @Autowired
    private MessageSource source;

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity handle(AuthenticationException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
