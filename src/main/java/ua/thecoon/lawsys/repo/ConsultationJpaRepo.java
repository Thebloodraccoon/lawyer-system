package ua.thecoon.lawsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.lawsys.model.entity.Client;

public interface ConsultationJpaRepo extends JpaRepository<Client, Long> {
}
