package com.exam.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mantenimientos")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date fecha;
    private String descripcion;
    private Double coste;
    
    private Long cocheId; // Relación con el ID del coche

    public Mantenimiento() {}

    public Mantenimiento(Date fecha, String descripcion, Double coste) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.coste = coste;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public Double getCoste() { return coste; }
    public void setCoste(Double coste) { this.coste = coste; }
    
    public Long getCocheId() { return cocheId; }
    public void setCocheId(Long cocheId) { this.cocheId = cocheId; }
}