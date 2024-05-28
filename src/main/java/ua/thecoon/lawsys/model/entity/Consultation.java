package ua.thecoon.lawsys.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "Consultation")
@Table(name = "t_consultation")
@ToString(exclude = {"client", "lawyer", "payments"})
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "consul_type")
    private ConsultationType consulType;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDateTime date;


    private Double cost;

    @Enumerated(EnumType.STRING)
    @Column(name = "consultation_status")
    private ConsultationStatus consultationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "consultation", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Payment> payments;
}