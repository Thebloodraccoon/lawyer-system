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