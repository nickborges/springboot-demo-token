package br.com.springboot.demo.autenticator.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationService authenticationService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder()); //diz qual o service que faz o login

    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll() //libera o endpoint auth
                .anyRequest().authenticated()   //para acessar qualquer endpoint precisa de autenticação
                //.and().formLogin();           //cria o formulário para login, caso não seja usado token
                .and().csrf().disable()        //desabilita a validação de ataque padrão do spring, pois a validação é por token
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //não cria sessão padrão do spring

    }

    /*public static void main(String args[]){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));

    }*/
}
