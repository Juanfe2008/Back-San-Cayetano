package com.prueba_back.prueba_java.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historicoFacturas")
public class HistoricoFacturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "TotalValue")
    private Float totalValue;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "IdFactura")
    private Long idFactura;

    @ManyToOne
    @JoinColumn(name = "IdUser")
    private Users idUser;
}
