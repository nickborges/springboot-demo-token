package br.com.springboot.demo.autenticator.config.secutiry;

import br.com.springboot.demo.autenticator.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenService {

    @Value("${app.demo.token.expiration}")
    private String expiration;

    @Value("${app.demo.token.secret}")
    private String secret;

    public String createToken(Authentication authentication){
        return Jwts.builder()
                .setIssuer("Autenticador Demo") //nome da aplicação que gerou o token
                .setSubject( ((User) authentication.getPrincipal()).getId().toString()) //que solicitou o token
                .setIssuedAt(new Date()) //quando o token foi gerado
                .setExpiration(new Date(new Date().getTime() + Long.parseLong(expiration))) //data de expiração do token
                .signWith(SignatureAlgorithm.HS256, secret) //criptografia do token
                .compact()
                ;
    }

}
