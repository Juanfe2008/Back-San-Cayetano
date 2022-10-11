package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.FacturasDto;
import com.prueba_back.prueba_java.Entity.Facturas;
import com.prueba_back.prueba_java.Repository.FacturaRepository;
import com.prueba_back.prueba_java.Response.FacturaResponse;
import com.prueba_back.prueba_java.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturasServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public FacturaResponse save(FacturasDto facturasDto) {

        try {
            Facturas facturas = new Facturas();

            facturas.setNombre_cliente(facturasDto.getNombre_cliente());
            facturas.setFecha(facturasDto.getFecha());
            facturas.setTelefono(facturasDto.getTelefono());
            facturas = this.facturaRepository.save(facturas);

            return FacturaResponse.builder().codResponse(201).message("Factura creada exitosamente").status("Created").factura(facturas).build();

        }catch (Exception e){
            return FacturaResponse.builder().codResponse(400).message(e.getMessage()).status("Bad Request").build();

        }
    }

    @Override
    public FacturaResponse update(FacturasDto facturasDto, Long Id) {
        try {
            Facturas facturas = new Facturas();

            facturas.setId(Id);
            facturas.setNombre_cliente(facturasDto.getNombre_cliente());
            facturas.setFecha(facturasDto.getFecha());
            facturas.setTelefono(facturasDto.getTelefono());
            facturas = this.facturaRepository.save(facturas);

            return FacturaResponse.builder().codResponse(200).message("Factura actualizada exitosamente").status("Ok").factura(facturas).build();


        }catch (Exception e){
            return FacturaResponse.builder().codResponse(400).message(e.getMessage()).status("Bad Request").build();

        }
    }

    @Override
    public FacturaResponse findAll() {
        try {

            List<Facturas> facturas = this.facturaRepository.findAll();

            return FacturaResponse.builder().codResponse(200).message("Facturas listadas exitosamente").status("Ok").facturaList(facturas).build();


        }catch (Exception e){

        }
        return null;
    }

    @Override
    public FacturaResponse findById(Long id) {
        try {
            Facturas facturas = this.facturaRepository.findByIdFactura(id);

            return FacturaResponse.builder().codResponse(200).message("Factura consultada exitosamente").status("Ok").factura(facturas).build();

        }catch (Exception e){
            return FacturaResponse.builder().codResponse(400).message(e.getMessage()).status("Bad Request").build();

        }
    }

    @Override
    public FacturaResponse delete(Long id) {
        try {
            this.facturaRepository.deleteById(id);
            return FacturaResponse.builder().codResponse(200).message("Factura eliminada exitosamente").status("Ok").build();

        }catch (Exception e){
            return FacturaResponse.builder().codResponse(400).message(e.getMessage()).status("Bad Request").build();

        }
    }

}


