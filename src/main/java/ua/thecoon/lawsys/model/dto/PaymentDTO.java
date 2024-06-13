package ua.thecoon.lawsys.model.dto;

import lombok.Data;
import ua.thecoon.lawsys.model.entity.PaymentStatus;

import java.util.Date;

@Data
public class PaymentDTO {
    private Long id;
    private Double amount;
    private Date paymentDate;
    private String paymentMethod;

    private PaymentStatus paymentStatus;

    private ConsultationDTO consultationDTO;
}
