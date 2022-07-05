package com.edu.miu.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private List<Integer> logs = new ArrayList<>();
//    @OneToMany(mappedBy = "user")


//    @JsonBackReference
//    @OneToOne(mappedBy = "user")
//    private Product product;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
