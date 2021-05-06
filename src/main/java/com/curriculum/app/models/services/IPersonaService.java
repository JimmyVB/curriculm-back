package com.curriculum.app.models.services;

import com.curriculum.app.models.entity.*;

public interface IPersonaService {

    public Persona save(Persona persona);
    public Persona findById(Long id);
    public Persona findByNombre(String nombre);

    public ExperienciaLaboral saveExperiencia(ExperienciaLaboral experienciaLaboral);
    public ExperienciaLaboral findExperienciaById(Long id);
    public void deleteExperiencia(Long id);

    public Estudio saveEstudio(Estudio estudio);
    public Estudio findEstudioById(Long id);
    public void deleteEstudio(Long id);

    public Certificacion saveCertificacion(Certificacion certificacion);
    public Certificacion findCertificacionById(Long id);
    public void deleteCertificacion(Long id);

    public Conocimiento saveConocimiento(Conocimiento conocimiento);
}
