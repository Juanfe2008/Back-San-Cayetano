package com.prueba_back.prueba_java.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prueba_back.prueba_java.Dto.CarDto;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Builder
@Accessors(prefix = { "res", "res_" })
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarSaveResponse {

    @JsonProperty("message")
    private String resMessage;

    @JsonProperty("status")
    private String resStatus;

    @JsonProperty("codResponse")
    private Integer resCodResponse;

    @JsonProperty("carSave")
    private CarDto resCarDto;
}
