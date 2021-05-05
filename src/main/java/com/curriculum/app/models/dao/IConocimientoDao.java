package com.curriculum.app.models.dao;

import com.curriculum.app.models.entity.Conocimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConocimientoDao extends JpaRepository<Conocimiento, Long> {
}
