package ua.thecoon.lawsys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "Payment")
@Table(name = "t_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;

    @OneToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}
