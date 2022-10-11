package com.prueba_back.prueba_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba_back.prueba_java.Entity.HistoricoFacturas;

@Repository
public interface HistoricoFacturasRepository extends JpaRepository<HistoricoFacturas, Long> {
}
