package ua.thecoon.lawsys.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.thecoon.lawsys.model.entity.Lawyer;
import ua.thecoon.lawsys.repo.LawyerJpaRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LawyerService {

    private final LawyerJpaRepo lawyerJpaRepo;

    @Transactional(readOnly = true)
    public List<Lawyer> getAllLawyers() {
        return lawyerJpaRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Lawyer getLawyer(Long id) {
        return lawyerJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lawyer not found with id " + id));
    }

    @Transactional
    public Lawyer createLawyer(Lawyer lawyer) {
        return lawyerJpaRepo.save(lawyer);
    }

    @Transactional
    public Lawyer updateLawyer(Long id, Lawyer lawyerDetails) {
        Lawyer existingLawyer = lawyerJpaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lawyer not found with id " + id));

        existingLawyer.setName(lawyerDetails.getName());
        existingLawyer.setEmail(lawyerDetails.getEmail());
        existingLawyer.setPhoneNum(lawyerDetails.getPhoneNum());
        existingLawyer.setSpecialization(lawyerDetails.getSpecialization());
        existingLawyer.setYearsOfExperience(lawyerDetails.getYearsOfExperience());
        existingLawyer.setLicenseNumber(lawyerDetails.getLicenseNumber());
        existingLawyer.setOfficeAddress(lawyerDetails.getOfficeAddress());
        existingLawyer.setBio(lawyerDetails.getBio());

        return lawyerJpaRepo.save(existingLawyer);
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
}