package ua.thecoon.lawsys.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@MappedSuperclass
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passwordHash;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="t_user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;

    @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Address address;
}
