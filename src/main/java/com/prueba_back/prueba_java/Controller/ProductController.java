package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Response.ProducSaveResponse;
import com.prueba_back.prueba_java.Response.ProductResponse;
import com.prueba_back.prueba_java.Service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    public ProductController(ServiceProduct productService) {
        this.productService = productService;
    }

    @Autowired
    private ServiceProduct productService;

    @GetMapping(value = "/list")
    public ResponseEntity<ProductResponse> ListProducts()throws IOException{
        return new ResponseEntity<ProductResponse>(productService.listAll(),HttpStatus.OK) ;
    }

    @GetMapping(value = "/listBy/{id}")
    public ResponseEntity<ProducSaveResponse> productsById(@PathVariable Long id){

        return new ResponseEntity<ProducSaveResponse>(productService.listById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<ProducSaveResponse> productsSave(@RequestBody ProductDto productDto){

        return new ResponseEntity<ProducSaveResponse>(productService.save(productDto),HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ProducSaveResponse> productsUpdate(@RequestBody ProductDto productDto){

        return new ResponseEntity<ProducSaveResponse>(productService.save(productDto),HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ProducSaveResponse> deleteById(@PathVariable Long id){
        return new ResponseEntity<ProducSaveResponse>(productService.deleteById(id),HttpStatus.OK);
    }
}
