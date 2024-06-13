package ua.thecoon.lawsys.model.dto;


import lombok.Data;
import ua.thecoon.lawsys.model.entity.ConsultationType;

import java.util.List;

@Data
public class LawyerDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private ConsultationType specialization;
    private int yearsOfExperience;
    private String licenseNumber;
    private String officeAddress;
    private String bio;

    private List<ConsultationDTO> consultations;
}
