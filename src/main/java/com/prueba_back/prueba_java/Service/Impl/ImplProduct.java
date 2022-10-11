package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.ProductDto;
import com.prueba_back.prueba_java.Entity.SystemKardex;
import com.prueba_back.prueba_java.Entity.Products;
import com.prueba_back.prueba_java.Mappers.ProductMapper;
import com.prueba_back.prueba_java.Repository.KardexRepository;
import com.prueba_back.prueba_java.Repository.ProductRepository;
import com.prueba_back.prueba_java.Response.ProducSaveResponse;
import com.prueba_back.prueba_java.Response.ProductResponse;
import com.prueba_back.prueba_java.Service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImplProduct implements ServiceProduct {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    KardexRepository kardexRepository;

    @Autowired
    ProductMapper productMapper;


    @Override
    public ProducSaveResponse save(ProductDto productDto) {
        try {
            Products products = new Products();
            if (productDto != null || productDto.name().isEmpty()){
                if (productDto.id() != null){
                    Products productsUpdate = productRepository.findByIdProduc(productDto.id());

                    Long NewQuantity = productDto.quantity() + productsUpdate.getQuantityProduct();

                    products.setId(productDto.id());
                    products.setNameProduct(productDto.name());
                    products.setValueProduct(productDto.value());
                    products.setWeightProduct(productDto.weight());
                    products.setQuantityProduct(NewQuantity);
                    products.setSupplier(productDto.supplier());
                    products.setUnitProduct(productDto.unit());
                    productRepository.save(products);
                    return productMapper.toResponseProductSave(products,201,"Producto Actualizado con éxito","201");
                }

                /* Kardex*/
                SystemKardex systemKardex = new SystemKardex();

                Float ValueTickets = productDto.value() * productDto.quantity();

                systemKardex.setName(productDto.name());
                systemKardex.setUnit(productDto.unit());
                systemKardex.setSupplier(productDto.supplier());
                systemKardex.setDate(new Date());
                systemKardex.setValue(productDto.value());
                systemKardex.setQuantityTickets(productDto.quantity());
                systemKardex.setValueTickets(ValueTickets);
                systemKardex.setQuantityBalance(productDto.quantity());
                systemKardex.setValueBalance(ValueTickets);
                kardexRepository.save(systemKardex);



                products.setNameProduct(productDto.name());
                products.setValueProduct(productDto.value());
                products.setWeightProduct(productDto.weight());
                products.setQuantityProduct(productDto.quantity());
                products.setSupplier(productDto.supplier());
                products.setUnitProduct(productDto.unit());
                productRepository.save(products);
                return productMapper.toResponseProductSave(products,201,"Producto registrado con éxito","201");
            }
            return productMapper.toResponseProductSave(null,400,"Error al registrar el producto","400");
        }catch (Exception e){
            return null;
        }


    }

    @Override
    public ProductResponse listAll() {
            try{
                List<Products> productDto =  productRepository.findAll();
                return productMapper.toResponseProductDto(productDto,200,"Consulta Exitosa","200");
            }catch (Exception e){
                return ProductResponse.builder()
                        .codResponse(400)
                        .message(e.toString())
                        .status("400")
                        .build();
            }



    }

    @Override
    public ProducSaveResponse listById(Long id) {

        try{
            if (id != null){

                Products products = productRepository.findByIdProduc(id);
                return ProducSaveResponse.builder().codResponse(200).message("cosnulta exitosa").build();


            }
            return productMapper.toResponseProductSave(null,400,"Falta el parametro ID para relaizar la consulta", "400");
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public ProducSaveResponse deleteById(Long id) {
        try{
            if (id != null){
                productRepository.deleteById(id);
                return productMapper.toResponseProductSave(null,200,"Producto Eliminiado con exito", "OK");
            }
            return productMapper.toResponseProductSave(null,404,"No se a proporcionado un ID de producto", "BAD REQUEST");
        }catch (Exception e){
            return productMapper.toResponseProductSave(null,404,e.toString(), "BAD REQUEST");
        }

    }
}
