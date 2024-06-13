package ua.thecoon.lawsys.model.dto;

import lombok.Data;
import ua.thecoon.lawsys.model.entity.ConsultationType;

@Data
public class LawyerItemDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private ConsultationType specialization;
    private int yearsOfExperience;
    private String licenseNumber;
    private String officeAddress;
    private String bio;
}
