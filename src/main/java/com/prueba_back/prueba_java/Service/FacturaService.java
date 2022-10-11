package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.FacturasDto;
import com.prueba_back.prueba_java.Entity.Facturas;
import com.prueba_back.prueba_java.Response.FacturaResponse;

public interface FacturaService {

    FacturaResponse save(FacturasDto facturas);

    FacturaResponse update(FacturasDto facturas, Long Id);

    FacturaResponse findAll();

    FacturaResponse findById(Long id);

    FacturaResponse delete(Long id);
}
