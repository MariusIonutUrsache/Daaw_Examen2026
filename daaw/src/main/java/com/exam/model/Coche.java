package com.exam.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coches")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String matricula;
    private Integer anioMatriculacion;

    public Coche() {}

    public Coche(String matricula, Integer anioMatriculacion) {
        this.matricula = matricula;
        this.anioMatriculacion = anioMatriculacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    
    public Integer getAnioMatriculacion() { return anioMatriculacion; }
    public void setAnioMatriculacion(Integer anioMatriculacion) { this.anioMatriculacion = anioMatriculacion; }
}