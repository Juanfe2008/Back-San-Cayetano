package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Cars;
import com.prueba_back.prueba_java.Response.CarResponse;
import com.prueba_back.prueba_java.Response.CarSaveResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {
    public CarResponse toResponseCarDto(List<Cars> cars, Integer codeResponse, String message, String status){
        return CarResponse.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .carDto(toCar(cars))
                .build();
    }

    public List<CarDto> toCar(List<Cars> cars){
        if (cars != null && !cars.isEmpty()){
            return cars.stream().map(this::toCarMap)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    public CarDto toCarMap(Cars cars){
        if (cars != null){
            return CarDto.builder()
                    .idProduct(cars.getIdProduc().getId())
                    .idUser(cars.getIdUser().getId())
                    .cantidad(cars.getCantidad())
                    .build();
        }
        return null;
    }

    public CarSaveResponse toResponseCarSave(Cars cars, Integer codeResponse, String message, String status){
        return CarSaveResponse.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .carDto(toCarSave(cars))
                .build();
    }

    public CarDto toCarSave(Cars cars){
        CarDto carDto = new CarDto();

        if (cars != null){
            carDto.idProduct(cars.getIdProduc().getId());
            carDto.idUser(cars.getIdUser().getId());
            carDto.cantidad(cars.getCantidad());

            return carDto;
        }
        return null;
    }
}
