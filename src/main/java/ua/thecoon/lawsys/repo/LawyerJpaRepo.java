package ua.thecoon.lawsys.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.lawsys.model.entity.ConsultationType;
import ua.thecoon.lawsys.model.entity.Lawyer;

import java.util.List;

public interface LawyerJpaRepo extends JpaRepository<Lawyer, Long> {
    Lawyer findLawyerByEmail(String email);
    List<Lawyer> findLawyersBySpecialization(ConsultationType type);

}
