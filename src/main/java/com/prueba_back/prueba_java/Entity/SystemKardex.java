package com.prueba_back.prueba_java.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SystemKardex {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idKardex")
    private Long id;

    @Column(name = "Name", length = 255)
    private String name;

    @Column(name = "Unit", length = 255)
    private String unit;

    @Column(name = "Supplier", length = 255)
    private String supplier;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Description", length = 255)
    private String description;

    @Column(name = "Value")
    private Float value;

    @Column(name = "QuantityTickets")
    private Long quantityTickets;

    @Column(name = "ValueTickets")
    private Float valueTickets;

    @Column(name = "QuantityDepartures")
    private Long quantityDepartures;

    @Column(name = "ValueDepartures")
    private Float valueDepartures;

    @Column(name = "ValueBalance")
    private Float valueBalance;

    @Column(name = "QuantityBalance")
    private Long quantityBalance;

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
