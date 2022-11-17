package com.prueba_back.prueba_java.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private Long phone;

    @Column(name = "Addres")
    private String addres;

    @Column(name = "Identification")
    private String identification;
    @Column(name = "UserName")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "TotalValue")
    private Float totalValue;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<HistoricoFacturas> historico;

}
