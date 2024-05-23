package ua.thecoon.lawsys.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity(name = "Lawyer")
@Table(name = "t_lawyer")
@ToString(exclude = "consultations")
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_num")
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialization")
    private ConsultationType specialization;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "office_address")
    private String officeAddress;

    @Column(name = "bio")
    private String bio;

    @OneToMany(mappedBy = "lawyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consultation> consultations;
}