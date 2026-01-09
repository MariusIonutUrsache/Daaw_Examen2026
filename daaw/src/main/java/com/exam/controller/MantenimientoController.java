package com.exam.controller;

import com.exam.model.Mantenimiento;
import com.exam.repository.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MantenimientoController {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    // GET /maintenances
    @GetMapping("/maintenances")
    public ResponseEntity<List<Mantenimiento>> listarMantenimientos() {
        return ResponseEntity.ok(mantenimientoRepository.findAll());
    }
}