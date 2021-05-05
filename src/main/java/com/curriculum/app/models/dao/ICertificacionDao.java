package com.curriculum.app.models.dao;

import com.curriculum.app.models.entity.Certificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICertificacionDao extends JpaRepository<Certificacion, Long> {
}
