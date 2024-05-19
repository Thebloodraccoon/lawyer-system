package ua.thecoon.lawsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.lawsys.model.entity.Client;
import ua.thecoon.lawsys.model.entity.Consultation;

public interface ConsultationJpaRepo extends JpaRepository<Consultation, Long> {
}
