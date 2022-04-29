package com.prueba_back.prueba_java.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "Name")
    private String nameUser;

    @Column(name = "Lastname")
    private String lastname;

    /* @Column(name = "Age")
    private Long age;*/

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Addres")
    private String addres;

    @Column(name = "Identification")
    private String identification;
    @Column(name = "UserName")
    private String username;

    @Column(name = "Password")
    private String password;

}
