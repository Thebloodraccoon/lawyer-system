package ua.thecoon.lawsys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Lawyer")
@Table(name = "t_lawyer")
public class Lawyer extends User {
    private String specialization;

    @OneToMany(mappedBy = "lawyer")
    private List<Consultation> consultations;
}
