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
public class KardexDto {


    @JsonProperty("name")
    private String name;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("supplier")
    private String supplier;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("description")
    private String description;

    @JsonProperty("value")
    private Float value;

    @JsonProperty("quantityTickets")
    private Long quantityTickets;

    @JsonProperty("valueTickets")
    private Float valueTickets;

    @JsonProperty("quantityDepartures")
    private Long quantityDepartures;

    @JsonProperty("valueDepartures")
    private Float valueDepartures;


    @JsonProperty("valueBalance")
    private Float valueBalance;

    @JsonProperty("quantityBalance")
    private Long quantityBalance;


}
