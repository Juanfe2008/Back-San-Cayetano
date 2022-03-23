package com.prueba_back.prueba_java.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(fluent = true)
public class CarDto {

    @JsonProperty("idUser")
    private Long idUser;

    @JsonProperty("idProduct")
    private Long idProduct;

    @JsonProperty("cantidad")
    private Long cantidad;

	

}
