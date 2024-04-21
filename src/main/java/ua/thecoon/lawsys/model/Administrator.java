package ua.thecoon.lawsys.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Administrator")
@Table(name = "t_administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passwordHash;
    private String address;
    private String phoneNum;

    @OneToMany(mappedBy = "administrator")
    private List<LawyerSalary> lawyerSalaries;
}