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
public class ProductDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private Float value;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("supplier")
    private String supplier;

	

}
