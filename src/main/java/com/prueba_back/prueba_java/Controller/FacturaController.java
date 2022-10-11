package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.FacturasDto;
import com.prueba_back.prueba_java.Response.FacturaResponse;
import com.prueba_back.prueba_java.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("factura")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    FacturaService facturaService;

    @GetMapping(value = "/list")
    public ResponseEntity<FacturaResponse> listFactura(){
        return new ResponseEntity<>(facturaService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<FacturaResponse> saveFacturas(@RequestBody FacturasDto facturasDto){
        return new ResponseEntity<FacturaResponse>(facturaService.save(facturasDto),HttpStatus.CREATED);
    }

    @GetMapping(value = "/listById/{id}")
    public ResponseEntity<FacturaResponse> findById(@PathVariable Long id){
        return new ResponseEntity<FacturaResponse>(facturaService.findById(id),HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<FacturaResponse> updateFacturas(@RequestBody FacturasDto facturasDto, @PathVariable Long id){
        return new ResponseEntity<FacturaResponse>(facturaService.update(facturasDto,id),HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<FacturaResponse> deleteById(@PathVariable Long id){
        return new ResponseEntity<FacturaResponse>(facturaService.delete(id),HttpStatus.OK);
    }
}
