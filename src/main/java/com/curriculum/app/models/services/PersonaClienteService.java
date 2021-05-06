package com.curriculum.app.models.services;

import com.curriculum.app.models.dao.*;
import com.curriculum.app.models.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaClienteService implements IPersonaService{

    @Autowired
    private IPersonaDao personaDao;

    @Autowired
    private IExperienciaLaboralDao experienciaLaboralDao;

    @Autowired
    private IEstudioDao estudioDao;

    @Autowired
    private ICertificacionDao certificacionDao;

    @Autowired
    private IConocimientoDao conocimientoDao;

    @Override
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    public Persona findById(Long id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public Persona findByNombre(String nombre) {

        String string = nombre;
        String[] parts = string.split("_");
        String nuevoNombre = parts[0]; // 123
        String nuevoApellido = parts[1];
        String criterioBusqueda = nuevoNombre+nuevoApellido;
        return personaDao.findByNombre(nombre);
    }

    @Override
    public ExperienciaLaboral saveExperiencia(ExperienciaLaboral experienciaLaboral) {
        return experienciaLaboralDao.save(experienciaLaboral);
    }

    @Override
    public ExperienciaLaboral findExperienciaById(Long id) {
        return experienciaLaboralDao.findById(id).orElse(null);
    }

    @Override
    public void deleteExperiencia(Long id) {
        experienciaLaboralDao.deleteById(id);
    }

    @Override
    public Estudio saveEstudio(Estudio estudio) {
        return estudioDao.save(estudio);
    }

    @Override
    public Estudio findEstudioById(Long id) {
        return estudioDao.findById(id).orElse(null);
    }

    @Override
    public void deleteEstudio(Long id) {
        estudioDao.deleteById(id);
    }

    @Override
    public Certificacion saveCertificacion(Certificacion certificacion) {
        return certificacionDao.save(certificacion);
    }

    @Override
    public Certificacion findCertificacionById(Long id) {
        return certificacionDao.findById(id).orElse(null);
    }

    @Override
    public void deleteCertificacion(Long id) {
        certificacionDao.deleteById(id);
    }

    @Override
    public Conocimiento saveConocimiento(Conocimiento conocimiento) {
        return conocimientoDao.save(conocimiento);
    }
}
