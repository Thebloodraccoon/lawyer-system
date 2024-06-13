package ua.thecoon.lawsys.model.dto;


import lombok.Data;
import ua.thecoon.lawsys.model.entity.ConsultationStatus;
import ua.thecoon.lawsys.model.entity.ConsultationType;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ConsultationDTO {
    private Long id;
    private ConsultationType consulType;
    private String name;
    private LocalDateTime date;
    private Double cost;
    private ConsultationStatus consultationStatus;
    private LawyerItemDTO lawyer;
    private ClientItemDTO client;

    private List<PaymentDTO> payments;
}
