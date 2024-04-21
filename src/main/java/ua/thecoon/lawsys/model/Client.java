package ua.thecoon.lawsys.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Client")
@Table(name = "t_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passwordHash;
    private String address;
    private String phoneNum;

    @OneToMany(mappedBy = "client")
    private List<Consultation> consultations;
}