package ua.thecoon.lawsys.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ClientDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private List<ConsultationDTO> consultations;
}