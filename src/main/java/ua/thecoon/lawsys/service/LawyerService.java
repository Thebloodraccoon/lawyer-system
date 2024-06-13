package ua.thecoon.lawsys.service;

import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.dto.LawyerDTO;
import ua.thecoon.lawsys.model.dto.LawyerItemDTO;
import ua.thecoon.lawsys.model.entity.ConsultationType;
import ua.thecoon.lawsys.model.entity.Lawyer;

import java.util.List;

public interface LawyerService {
    List<LawyerItemDTO> getAllLawyers();
    LawyerDTO getLawyer(Long id);
    LawyerItemDTO getItemLawyer(Long id);
    LawyerDTO createLawyer(Lawyer lawyer);
    LawyerDTO updateLawyer(Long id, LawyerDTO lawyerDetails);
    boolean deleteLawyer(Long id);
    Lawyer findLawyerByEmail(String email);
    @Transactional(readOnly = true)
    List<LawyerDTO> getLawyerByType(ConsultationType type);
}
