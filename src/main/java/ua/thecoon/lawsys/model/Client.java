package ua.thecoon.lawsys.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Client")
@Table(name = "t_client")
public class Client extends User {
    @Column(name = "phone_num")
    private String phoneNumber;


    @OneToMany(mappedBy = "client_id")
    private List<Consultation> consultations;

}