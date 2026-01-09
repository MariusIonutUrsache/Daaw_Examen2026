package com.exam.controller;

import com.exam.model.Coche;
import com.exam.model.Mantenimiento;
import com.exam.repository.CocheRepository;
import com.exam.repository.MantenimientoRepository;
import com.exam.exception.RecursoNoEncontradoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
public class CocheController {

    @Autowired
    private CocheRepository cocheRepository;

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    // POST /cars
    @PostMapping("/cars")
    public ResponseEntity<Coche> crearCoche(@RequestBody Coche coche) {
        if (coche.getMatricula() == null || coche.getAnioMatriculacion() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Coche cocheGuardado = cocheRepository.save(coche);
        return ResponseEntity.created(URI.create("/cars/" + cocheGuardado.getId())).body(cocheGuardado);
    }

    // GET /cars/{id}
    @GetMapping("/cars/{id}")
    public ResponseEntity<Coche> obtenerCoche(@PathVariable Long id) {
        Coche coche = cocheRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Coche no encontrado con id: " + id));
        return ResponseEntity.ok(coche);
    }

    // POST /cars/{id}/maintenances
    @PostMapping("/cars/{id}/maintenances")
    public ResponseEntity<Mantenimiento> agregarMantenimiento(@PathVariable Long id, @RequestBody Mantenimiento mantenimiento) {
        Coche coche = cocheRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Coche no existe: " + id));

        if (mantenimiento.getFecha() == null || mantenimiento.getDescripcion() == null || mantenimiento.getCoste() == null) {
             return ResponseEntity.badRequest().build();
        }

        mantenimiento.setCocheId(coche.getId());
        Mantenimiento mantenimientoGuardado = mantenimientoRepository.save(mantenimiento);
        
        return ResponseEntity.created(URI.create("/maintenances/" + mantenimientoGuardado.getId())).body(mantenimientoGuardado);
    }
}