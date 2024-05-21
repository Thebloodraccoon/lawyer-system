package ua.thecoon.lawsys.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.thecoon.lawsys.model.entity.Schedule;

public interface ScheduleJpaRepo extends JpaRepository<Schedule, Long> {
}
