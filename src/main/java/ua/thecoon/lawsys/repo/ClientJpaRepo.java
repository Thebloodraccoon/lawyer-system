package ua.thecoon.lawsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.lawsys.model.entity.Client;

import java.util.Optional;

public interface ClientJpaRepo extends JpaRepository<Client, Long> {
    Client findClientByEmail(String email);
}
