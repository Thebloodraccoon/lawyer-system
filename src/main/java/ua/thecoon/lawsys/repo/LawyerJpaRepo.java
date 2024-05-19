package ua.thecoon.lawsys.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.lawsys.model.entity.Lawyer;

public interface LawyerJpaRepo extends JpaRepository<Lawyer, Long> {
    Lawyer findLawyerByEmail(String email);
}
