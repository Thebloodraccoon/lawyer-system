package ua.thecoon.lawsys.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity(name = "Salary")
@Table(name = "t_lawyer_payment")
public class LawyerSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private Administrator administrator;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "payment_month")
    private int paymentMonth;
}
