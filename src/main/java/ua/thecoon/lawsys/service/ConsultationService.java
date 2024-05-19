package ua.thecoon.lawsys.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.repo.ConsultationJpaRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final ConsultationJpaRepo consultationJpaRepo;

    @Transactional(readOnly = true)
    public List<Consultation> getAllConsultations() {
        return consultationJpaRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Consultation getConsultation(Long id) {
        return consultationJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found with id " + id));
    }

    @Transactional
    public Consultation createConsultation(Consultation consultation) {
        return consultationJpaRepo.save(consultation);
    }

    @Transactional
    public Consultation updateConsultation(Long id, Consultation updatedConsultation) {
        Consultation existingConsultation = consultationJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found with id " + id));

        if (updatedConsultation.getConsulType() != null) {
            existingConsultation.setConsulType(updatedConsultation.getConsulType());
        }
        if (updatedConsultation.getName() != null) {
            existingConsultation.setName(updatedConsultation.getName());
        }
        if (updatedConsultation.getDate() != null) {
            existingConsultation.setDate(updatedConsultation.getDate());
        }
        if (updatedConsultation.getCost() != null) {
            existingConsultation.setCost(updatedConsultation.getCost());
        }
        if (updatedConsultation.getConsultationStatus() != null) {
            existingConsultation.setConsultationStatus(updatedConsultation.getConsultationStatus());
        }
        if (updatedConsultation.getLawyer() != null) {
            existingConsultation.setLawyer(updatedConsultation.getLawyer());
        }
        if (updatedConsultation.getClient() != null) {
            existingConsultation.setClient(updatedConsultation.getClient());
        }

        return consultationJpaRepo.save(existingConsultation);
    }

    @Transactional
    public boolean deleteConsultation(Long id) {
        Consultation consultation = consultationJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation not found with id " + id));
        consultationJpaRepo.delete(consultation);
        return true;
    }
}