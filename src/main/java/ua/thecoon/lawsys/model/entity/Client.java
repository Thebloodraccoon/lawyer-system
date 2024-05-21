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

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_num")
    private String phoneNum;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Consultation> consultations;
}