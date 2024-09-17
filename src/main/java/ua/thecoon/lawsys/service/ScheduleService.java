package ua.thecoon.lawsys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.thecoon.lawsys.model.dto.ConsultationDTO;
import ua.thecoon.lawsys.model.dto.LawyerItemDTO;
import ua.thecoon.lawsys.model.dto.ScheduleDTO;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.model.entity.Schedule;
import ua.thecoon.lawsys.model.mapper.ConsultationMapper;
import ua.thecoon.lawsys.model.mapper.LawyerMapper;
import ua.thecoon.lawsys.model.mapper.ScheduleMapper;
import ua.thecoon.lawsys.repo.ScheduleJpaRepo;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleJpaRepo scheduleJpaRepo;
    private final ScheduleMapper scheduleMapper;
    private final LawyerMapper lawyerMapper;
    private final ConsultationMapper consultationMapper;

    public List<ScheduleDTO> getSchedule() {
        List<Schedule> all =
                scheduleJpaRepo.findAll();

        return all.stream()
                .map(scheduleMapper::toDto)
                .sorted(Comparator.comparing(ScheduleDTO::getDate))
                .toList();
    }
    public void createSchedule(LocalDateTime date, LawyerItemDTO lawyerItemDTO, ConsultationDTO consultationDTO) {
        Lawyer lawyer = lawyerMapper.toItemEntity(lawyerItemDTO);
        Consultation consultation = consultationMapper.toEntity(consultationDTO);

        Schedule schedule = new Schedule();
        schedule.setDate(date);
        schedule.setLawyer(lawyer);
        schedule.setConsultation(consultation);

        scheduleJpaRepo.save(schedule);
    }

}
