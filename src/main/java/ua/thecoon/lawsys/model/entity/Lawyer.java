package ua.thecoon.lawsys.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Lawyer")
@Table(name = "t_lawyer")
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization;

    @OneToMany(mappedBy = "lawyer")
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "lawyer")
    private List<Schedule> schedules;
}
