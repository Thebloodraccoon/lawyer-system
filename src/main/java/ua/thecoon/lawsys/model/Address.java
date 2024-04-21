package ua.thecoon.lawsys.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Address")
@Table(name = "t_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String state;
    private  String place;
    private String street;
    @Column(name = "house_num")
    private String houseNum;
    private String apartment;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
