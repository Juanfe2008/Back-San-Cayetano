package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Cars;
import com.prueba_back.prueba_java.Response.CarResponse;
import com.prueba_back.prueba_java.Response.CarSaveResponse;

import java.util.List;

public interface ServiceCars {

    CarSaveResponse save(CarDto car);

    CarResponse listAll();

    List<Cars> listByUser(Long idUser);
}
