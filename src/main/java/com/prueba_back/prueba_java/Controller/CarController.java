package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Cars;
import com.prueba_back.prueba_java.Response.CarResponse;
import com.prueba_back.prueba_java.Response.CarSaveResponse;
import com.prueba_back.prueba_java.Service.ServiceCars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("car")
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private ServiceCars carService;

    @GetMapping(value = "/list")
    public ResponseEntity<CarResponse> ListProducts()throws IOException {
        return new ResponseEntity<CarResponse>(carService.listAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<CarSaveResponse> CarsSave(@RequestBody CarDto car){

        return new ResponseEntity<CarSaveResponse>(carService.save(car),HttpStatus.CREATED);
    }

    @GetMapping(value = "/listByUser/{idUser}")
    public List<Cars> carsByUser(@PathVariable Long idUser){
        return this.carService.listByUser(idUser);
    }

}
