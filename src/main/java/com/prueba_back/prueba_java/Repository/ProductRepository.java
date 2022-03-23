package com.prueba_back.prueba_java.Repository;

import com.prueba_back.prueba_java.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

    @Query(value = "select * from products where idproducts = :idProduct", nativeQuery = true)
    Products findByIdProduc(@Param("idProduct")Long idProduct);
}
