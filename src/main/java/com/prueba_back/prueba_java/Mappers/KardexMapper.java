package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.KardexDto;
import com.prueba_back.prueba_java.Entity.SystemKardex;
import com.prueba_back.prueba_java.Response.KardexResponse;
import com.prueba_back.prueba_java.Response.KardexSaveResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KardexMapper {
    public KardexResponse toResponseKardexDto(List<SystemKardex> systemKardexList, Integer codeResponse, String message, String status){
        return KardexResponse.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .kardexDto(toKardex(systemKardexList))
                .build();
    }

    public List<KardexDto> toKardex(List<SystemKardex> systemKardexes){
        if (systemKardexes != null && !systemKardexes.isEmpty()){
            return systemKardexes.stream().map(this::toKardexMapp)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public KardexDto toKardexMapp(SystemKardex systemKardex){
        if (systemKardex != null){
            return KardexDto.builder()
                    .name(systemKardex.getName())
                    .unit(systemKardex.getUnit())
                    .supplier(systemKardex.getSupplier())
                    .date(systemKardex.getDate())
                    .description(systemKardex.getDescription())
                    .value(systemKardex.getValue())
                    .quantityTickets(systemKardex.getQuantityTickets())
                    .valueTickets(systemKardex.getValueTickets())
                    .quantityDepartures(systemKardex.getQuantityDepartures())
                    .valueDepartures(systemKardex.getValueDepartures())
                    .valueBalance(systemKardex.getValueBalance())
                    .build();
        }
        return null;
    }

    public KardexSaveResponse toResponseKardexSave(SystemKardex systemKardex, Integer codeResponse, String message, String status){
        return KardexSaveResponse.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .build();
    }
}
