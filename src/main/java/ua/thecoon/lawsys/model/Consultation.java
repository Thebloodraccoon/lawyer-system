package ua.thecoon.lawsys.model;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "Consultation")
@Table(name = "t_consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String consulType;
    private String name;
    private Date date;
    private String description;
    private ConsultationStatus consultationStatus;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "t_consult_payments",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_id")
    )
    private List<Payment> payments;
}