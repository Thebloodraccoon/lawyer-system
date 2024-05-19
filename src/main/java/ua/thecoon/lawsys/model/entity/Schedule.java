package ua.thecoon.lawsys.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;


@Data
@Entity(name = "Schedule")
@Table(name = "t_schedule")
@ToString(exclude = "lawyer")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "lawyer_id", referencedColumnName = "id")
    private Lawyer lawyer;

    @ManyToOne
    @JoinColumn(name = "consultation_id", referencedColumnName = "id")
    private Consultation consultation;
}
