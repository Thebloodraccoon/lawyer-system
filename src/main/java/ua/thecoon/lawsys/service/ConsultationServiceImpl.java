package ua.thecoon.lawsys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.dto.ConsultationDTO;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.model.entity.ConsultationType;
import ua.thecoon.lawsys.model.mapper.ConsultationMapper;
import ua.thecoon.lawsys.repo.ConsultationJpaRepo;

@Service
@RequiredArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationJpaRepo consultationJpaRepo;
    private final ConsultationMapper consultationMapper;

    @Transactional
    public ConsultationDTO createConsultation(ConsultationDTO consultationDTO) {
        Consultation consultation = consultationMapper.toEntity(consultationDTO);

        Consultation save = consultationJpaRepo.save(consultation);

        return consultationMapper.toDto(save);
    }

    public double getConsultationCost(ConsultationType type) {
        return type.getCost();
    }

    @Transactional
    public boolean deleteConsultation(Long id) {
        consultationJpaRepo.deleteById(id);
        return true;
    }
}