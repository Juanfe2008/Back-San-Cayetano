package com.prueba_back.prueba_java.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDto {

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("valor_unitario")
    private String valor_unitario;
}
