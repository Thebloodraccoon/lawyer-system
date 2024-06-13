package ua.thecoon.lawsys.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.dto.LawyerDTO;
import ua.thecoon.lawsys.model.dto.LawyerItemDTO;
import ua.thecoon.lawsys.model.entity.ConsultationType;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.model.mapper.LawyerMapper;
import ua.thecoon.lawsys.repo.LawyerJpaRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LawyerServiceImpl implements LawyerService {
    private final LawyerJpaRepo lawyerJpaRepo;
    private final LawyerMapper lawyerMapper;

    @Transactional(readOnly = true)
    public List<LawyerItemDTO> getAllLawyers() {
        List<Lawyer> all = lawyerJpaRepo.findAll();

        return all.stream()
                .map(lawyerMapper::toItemDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public LawyerDTO getLawyer(Long id) {
        Lawyer lawyer = lawyerJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lawyer not found with id " + id));

        return lawyerMapper.toDto(lawyer);
    }

    @Transactional(readOnly = true)
    public LawyerItemDTO getItemLawyer(Long id) {
        Lawyer lawyer = lawyerJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lawyer not found with id " + id));

        return lawyerMapper.toItemDto(lawyer);
    }

    @Transactional
    public LawyerDTO createLawyer(Lawyer lawyer) {
        Lawyer save = lawyerJpaRepo.save(lawyer);

        return lawyerMapper.toDto(save);
    }

    @Transactional
    public LawyerDTO updateLawyer(Long id, LawyerDTO lawyerDetails) {
        Lawyer existingLawyer = lawyerJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lawyer not found with id " + id));


        if (lawyerDetails.getName() != null) {
            existingLawyer.setName(lawyerDetails.getName());
        }
        if (lawyerDetails.getEmail() != null) {
            existingLawyer.setEmail(lawyerDetails.getEmail());
        }
        if (lawyerDetails.getPhoneNum() != null) {
            existingLawyer.setPhoneNum(lawyerDetails.getPhoneNum());
        }

        if (lawyerDetails.getYearsOfExperience() >= 1) {
            existingLawyer.setYearsOfExperience(lawyerDetails.getYearsOfExperience());
        }
        if (lawyerDetails.getLicenseNumber() != null) {
            existingLawyer.setLicenseNumber(lawyerDetails.getLicenseNumber());
        }
        if (lawyerDetails.getOfficeAddress() != null) {
            existingLawyer.setOfficeAddress(lawyerDetails.getOfficeAddress());
        }
        if (lawyerDetails.getBio() != null) {
            existingLawyer.setBio(lawyerDetails.getBio());
        }

        Lawyer save = lawyerJpaRepo.save(existingLawyer);

        return lawyerMapper.toDto(save);
    }

    @Transactional
    public boolean deleteLawyer(Long id) {
        Lawyer lawyer = lawyerJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lawyer not found with id " + id));
        lawyerJpaRepo.delete(lawyer);

        return true;
    }

    @Transactional(readOnly = true)
    public Lawyer findLawyerByEmail(String email) {
        return lawyerJpaRepo.findLawyerByEmail(email);

    }

    @Transactional(readOnly = true)
    public List<LawyerDTO> getLawyerByType(ConsultationType type) {
        List<Lawyer> lawyersBySpecialization = lawyerJpaRepo.findLawyersBySpecialization(type);

        return lawyersBySpecialization.stream()
                .map(lawyerMapper::toDto)
                .toList();
    }
}