package com.curriculum.app.models.dao;

import com.curriculum.app.models.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
}
