package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.HistoricoFacturasDto;
import com.prueba_back.prueba_java.Entity.HistoricoFacturas;
import com.prueba_back.prueba_java.Response.HistoricoFacturaResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HistoricoFacturasMappers {

    public HistoricoFacturaResponse toResponseFacturasHistorico(List<HistoricoFacturas> historicoFacturas, Integer codeResponse, String message, String status){
        return HistoricoFacturaResponse.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .historicoFacurasDto(toHistorico(historicoFacturas))
                .build();
    }

    public List<HistoricoFacturasDto> toHistorico(List<HistoricoFacturas> historicoFacturas){
        if(historicoFacturas != null && !historicoFacturas.isEmpty()){
            return historicoFacturas.stream()
                    .map(this::toHistoricoMapp)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public HistoricoFacturasDto toHistoricoMapp(HistoricoFacturas historicoFacturas){
        if (historicoFacturas != null){
            return HistoricoFacturasDto.builder()
                    .idUser(historicoFacturas.getIdUser().getId())
                    .idFactura(historicoFacturas.getIdFactura())
                    .fecha(historicoFacturas.getFecha())
                    .totalValue(historicoFacturas.getTotalValue())
                    .build();
        }
        return null;
    }
}
