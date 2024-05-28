package ua.thecoon.lawsys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.lawsys.model.entity.Schedule;
import ua.thecoon.lawsys.repo.ScheduleJpaRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleJpaRepo scheduleJpaRepo;

    public List<Schedule> getSchedule() {
        List<Schedule> all = scheduleJpaRepo.findAll();


        return all;
    }

    public void createSchedule(Schedule schedule) {
        scheduleJpaRepo.save(schedule);
    }

}
