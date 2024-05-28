package ua.thecoon.lawsys.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@Entity(name = "Schedule")
@Table(name = "t_schedule")
@ToString(exclude = "lawyer")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
}
