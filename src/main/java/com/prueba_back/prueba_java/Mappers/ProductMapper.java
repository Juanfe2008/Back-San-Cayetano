package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Response.ProducSaveResponse;
import com.prueba_back.prueba_java.Response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductResponse toResponseProductDto(List<Products> products, Integer codeResponse, String message, String status){
        return ProductResponse.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .productDto(toProduct(products))
                .build();
    }

    public List<ProductDto> toProduct(List<Products> products){
        if (products != null && !products.isEmpty()){
           return products.stream()
                   .map(this::toProductMap)
                   .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public ProductDto toProductMap(Products products){
        if (products != null){
            return ProductDto.builder()
                    .id(products.getId())
                    .name(products.getNameProduct())
                    .value(products.getValueProduct())
                    .weight(products.getWeightProduct())
                    .quantity(products.getQuantityProduct())
                    .unit(products.getUnitProduct())
                    .supplier(products.getSupplier())
                    .build();
        }
        return null;
    }

    public ProducSaveResponse toResponseProductSave(Products products, Integer codeResponse, String message, String status){
        return ProducSaveResponse.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .productDto(toProductSave(products))
                .build();
    }

    public ProductDto toProductSave(Products products){
        ProductDto productDto = new ProductDto();

        if (products != null){
            productDto.name(products.getNameProduct());
            productDto.value(products.getValueProduct());
            productDto.weight(products.getWeightProduct());
            productDto.quantity(products.getQuantityProduct());
            productDto.unit(products.getUnitProduct());
            productDto.supplier(products.getSupplier());
            return productDto;
        }
        return null;
    }
}
