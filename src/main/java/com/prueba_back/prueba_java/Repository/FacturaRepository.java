package com.prueba_back.prueba_java.Repository;

import com.prueba_back.prueba_java.Entity.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Facturas,Long> {

    @Query(value = "SELECT * FROM facturas f where f.id = :id",nativeQuery = true)
    Facturas findByIdFactura(@Param("id")Long id);
}
