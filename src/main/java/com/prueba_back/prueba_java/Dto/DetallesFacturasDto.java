package com.prueba_back.prueba_java.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallesFacturasDto {

    @JsonProperty("cantidad")
    private String cantidad;

    @JsonProperty("producto_id")
    private Long producto_id;

    @JsonProperty("factura_id")
    private Long factura_id;
}
