package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.CarDto;
import com.prueba_back.prueba_java.Entity.Cars;
import com.prueba_back.prueba_java.Entity.SystemKardex;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Mappers.CarMapper;
import com.prueba_back.prueba_java.Repository.CarsRepository;
import com.prueba_back.prueba_java.Repository.KardexRepository;
import com.prueba_back.prueba_java.Repository.ProductRepository;
import com.prueba_back.prueba_java.Repository.UserRepository;
import com.prueba_back.prueba_java.Response.CarResponse;
import com.prueba_back.prueba_java.Response.CarSaveResponse;
import com.prueba_back.prueba_java.Service.ServiceCars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarsImpl implements ServiceCars {

    @Autowired
    CarsRepository carRepository;

    @Autowired
    KardexRepository kardexRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CarMapper carMapper;




    @Override
    public CarSaveResponse save(CarDto car) {
        try{
            Cars cars1 = new Cars();
            if (car.idProduct() != null){
                Products products = productRepository.findByIdProduc(car.idProduct());
                if (products != null){
                    if (car.cantidad() > products.getQuantityProduct()){
                        return carMapper.toResponseCarSave(null,400,"No se puede comprar mas productos de los que hay en existencia","400");
                    }
                    if (car.cantidad() < products.getQuantityProduct()){
                        /*productRepository.deleteById(products.getId());*/
                        Products products1 = new Products();

                        Long newQuantity = products.getQuantityProduct() - car.cantidad();

                        products1.setId(products.getId());
                        products1.setNameProduct(products.getNameProduct());
                        products1.setValueProduct(products.getValueProduct());
                        products1.setWeightProduct(products.getWeightProduct());
                        products1.setQuantityProduct(newQuantity);
                        productRepository.save(products1);


                        /* Kardex*/
                        SystemKardex systemKardex = new SystemKardex();

                        Float Value = products.getValueProduct() * car.cantidad();

                        systemKardex.setName(products.getNameProduct());
                        systemKardex.setUnit(products.getUnitProduct());
                        systemKardex.setSupplier(products.getSupplier());
                        systemKardex.setDate(new Date());
                        systemKardex.setValue(products.getValueProduct());
                        systemKardex.setQuantityDepartures(car.cantidad());
                        systemKardex.setValueDepartures(Value);
                        systemKardex.setQuantityBalance(products.getQuantityProduct());
                        systemKardex.setValueBalance(Value);
                        kardexRepository.save(systemKardex);
                    }
                }
            }

            Products products = productRepository.findByIdProduc(car.idProduct());
            Users users = userRepository.findByIdUsers(car.idUser());

            if(car != null){
                cars1.setCantidad(car.cantidad());
                cars1.setIdProduc(products);
                cars1.setIdUser(users);
                carRepository.save(cars1);
                return carMapper.toResponseCarSave(cars1,201,"Registro agregado al carro agregado exitosamente","201");
            }
            return carMapper.toResponseCarSave(null,201,"Registro agregado al carro agregado exitosamente","201");

        }catch (Exception e){
            return carMapper.toResponseCarSave(null, 400, e.toString(),
                    "400");
        }


    }

    @Override
    public CarResponse listAll() {

        try {
            List<Cars> cars = carRepository.findAll();
            return carMapper.toResponseCarDto(cars,200,"Lista Consultada con exito","200");
        }catch (Exception e){
            return CarResponse.builder()
                    .codResponse(400)
                    .message(e.toString())
                    .status("400")
                    .build();
        }
    }

    @Override
    public List<Cars> listByUser(Long idUser) {
        List<Cars> cars = carRepository.findByIdUser(idUser);
        return cars;
    }
}
