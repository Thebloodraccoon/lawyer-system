package ua.thecoon.lawsys.model.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDTO {
    private Long id;
    private LocalDateTime date;
    private LawyerItemDTO lawyer;

    private ConsultationDTO consultation;
}
