package com.prueba_back.prueba_java.Repository;

import com.prueba_back.prueba_java.Entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars,Long> {

    @Query(value = "select * from car where id = :idUser", nativeQuery = true)
    List<Cars> findByIdUser(@Param("idUser")Long idUser);
}
