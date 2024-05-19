package ua.thecoon.lawsys.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Consultation")
@Table(name = "t_consultation")
@ToString(exclude = "client")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String consulType;
    private String name;
    private Date date;
    private Double cost;

    @Enumerated(EnumType.STRING)
    private ConsultationStatus consultationStatus;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "consultation", fetch = FetchType.EAGER)
    private List<Payment> payments;
}