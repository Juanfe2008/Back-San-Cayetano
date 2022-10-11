package com.prueba_back.prueba_java.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class HistoricoFacturasDto {

    @JsonProperty("totalValue")
    private Float totalValue;

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("idFactura")
    private Long idFactura;

    @JsonProperty("idUser")
    private Long idUser;

    @JsonProperty("operacion")
    private Long operacion;

}
