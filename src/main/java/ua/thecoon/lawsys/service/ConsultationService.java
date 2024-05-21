package ua.thecoon.lawsys.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.entity.Consultation;
import ua.thecoon.lawsys.model.entity.ConsultationType;
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
    public void createConsultation(Consultation consultation) {
        consultationJpaRepo.save(consultation);
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

    public double getConsultationCost(ConsultationType type) {
        return switch (type) {
            case CIVIL_LAW -> 100.0;
            case CRIMINAL_LAW -> 150.0;
            case LABOR_LAW -> 120.0;
            case FAMILY_LAW -> 130.0;
            case REAL_ESTATE_AND_PROPERTY_LAW -> 140.0;
            case CORPORATE_LAW -> 200.0;
            case TAX_LAW -> 180.0;
            case ADMINISTRATIVE_LAW -> 110.0;
            case INTELLECTUAL_PROPERTY_LAW -> 170.0;
            case BANKRUPTCY_AND_FINANCIAL_LAW -> 160.0;
            default -> throw new IllegalArgumentException("Unknown consultation type: " + type);
        };
    }

}