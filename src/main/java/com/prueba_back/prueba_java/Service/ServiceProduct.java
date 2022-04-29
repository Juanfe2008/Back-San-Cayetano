package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Response.ProducSaveResponse;
import com.prueba_back.prueba_java.Response.ProductResponse;

public interface ServiceProduct {

    public ProducSaveResponse save(ProductDto productDto);

    public ProductResponse listAll();

    public ProducSaveResponse listById(Long id);

    public ProductDto update(Long id, ProductDto productDto);

    public ProducSaveResponse deleteById(Long id);

}
