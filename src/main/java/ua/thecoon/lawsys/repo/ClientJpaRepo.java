package ua.thecoon.lawsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.lawsys.model.entity.Client;

public interface ClientJpaRepo extends JpaRepository<Client, Long> {
    Client findClientByEmail(String email);
}
