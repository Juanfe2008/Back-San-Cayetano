package com.prueba_back.prueba_java.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba_back.prueba_java.Dto.FacturasDto;
import com.prueba_back.prueba_java.Dto.GenericDto;
import com.prueba_back.prueba_java.Entity.Facturas;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@Accessors(prefix = { "res", "res_" })
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacturaResponse {

    @JsonProperty("message")
    private String resMessage;

    @JsonProperty("status")
    private String resStatus;

    @JsonProperty("codResponse")
    private Integer resCodResponse;

    @JsonProperty("factura")
    private Facturas resFactura;

    @JsonProperty("facturasList")
    private List<Facturas> resFacturaList;
}
