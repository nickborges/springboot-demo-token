package br.com.springboot.demo.autenticator.repository;

import br.com.springboot.demo.autenticator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
