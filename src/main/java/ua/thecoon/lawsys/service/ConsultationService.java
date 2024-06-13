package ua.thecoon.lawsys.service;

import ua.thecoon.lawsys.model.dto.ConsultationDTO;
import ua.thecoon.lawsys.model.entity.ConsultationType;


public interface ConsultationService {
    ConsultationDTO createConsultation(ConsultationDTO consultationDTO);
    double getConsultationCost(ConsultationType type);
}
