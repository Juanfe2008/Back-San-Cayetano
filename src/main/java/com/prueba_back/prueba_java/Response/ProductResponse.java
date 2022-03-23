package com.prueba_back.prueba_java.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba_back.prueba_java.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(prefix = { "res", "res_" })
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {
    @JsonProperty("message")
    private String resMessage;

    @JsonProperty("status")
    private String resStatus;

    @JsonProperty("codResponse")
    private Integer resCodResponse;

    @JsonProperty("products")
    private List<ProductDto> resProductDto;

}
