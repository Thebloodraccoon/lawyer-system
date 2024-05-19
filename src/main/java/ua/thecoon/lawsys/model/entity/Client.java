package ua.thecoon.lawsys.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity(name = "Client")
@Table(name = "t_client")
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_num", nullable = false)
    private String phoneNum;

    @OneToMany(mappedBy = "client")
    private List<Consultation> consultations;
}