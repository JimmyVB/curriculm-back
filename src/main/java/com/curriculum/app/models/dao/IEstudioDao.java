package com.curriculum.app.models.dao;

import com.curriculum.app.models.entity.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudioDao extends JpaRepository<Estudio, Long> {
}
