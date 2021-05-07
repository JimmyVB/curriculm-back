package com.curriculum.app.models.dao;

import com.curriculum.app.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPersonaDao extends JpaRepository<Persona, Long> {

    @Query("select p from Persona p where p.nombre=?1 and p.apellido=?2")
    public Persona findByNombre(String nombre, String apellido);

    @Query("select p from Persona p where p.usuario.id=?1")
    public Persona findByUsuarioId(Long id);
}
