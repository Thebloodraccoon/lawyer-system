package ua.thecoon.lawsys.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Entity(name = "Payment")
@Table(name = "t_payment")
@ToString(exclude = "consultation")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Date paymentDate;
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn(name = "consultation_id", insertable = false, updatable = false)
    private Consultation consultation;
}
