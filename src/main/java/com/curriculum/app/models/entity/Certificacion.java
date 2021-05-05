package com.curriculum.app.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "certificaciones")
public class Certificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fechaCertifacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCertifacion() {
        return fechaCertifacion;
    }

    public void setFechaCertifacion(String fechaCertifacion) {
        this.fechaCertifacion = fechaCertifacion;
    }
}
