package com.prueba_back.prueba_java.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturasDto {

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("nombre_cliente")
    private String nombre_cliente;

    @JsonProperty("telefono")
    private String telefono;
}
