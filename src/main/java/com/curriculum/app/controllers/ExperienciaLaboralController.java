package com.curriculum.app.controllers;

import com.curriculum.app.models.common.ServiceResult;
import com.curriculum.app.models.entity.ExperienciaLaboral;
import com.curriculum.app.models.services.IPersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/experiencia")
public class ExperienciaLaboralController {

    private final Logger logger = LoggerFactory.getLogger(ExperienciaLaboralController.class);

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> create(@RequestBody ExperienciaLaboral experienciaLaboral){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Experiencia Laboral creada");
            serviceResult.setData(personaService.saveExperiencia(experienciaLaboral));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ServiceResult> update(@RequestBody ExperienciaLaboral experienciaLaboral, @PathVariable Long id){

        ServiceResult serviceResult = new ServiceResult();
        try {
            ExperienciaLaboral experienciaLaboralActual = personaService.findExperienciaById(id);
            ExperienciaLaboral nuevaExperienciaLaboral = null;

            experienciaLaboralActual.setTitulo(experienciaLaboral.getTitulo());
            experienciaLaboralActual.setDescripcion(experienciaLaboral.getDescripcion());
            experienciaLaboralActual.setFechaInicio(experienciaLaboral.getFechaInicio());
            experienciaLaboralActual.setFechaFin(experienciaLaboral.getFechaFin());

            nuevaExperienciaLaboral = personaService.saveExperiencia(experienciaLaboralActual);

            serviceResult.setMessage("Experiencia Laboral actualizada");
            serviceResult.setData(nuevaExperienciaLaboral);

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable Long id){

        ServiceResult serviceResult = new ServiceResult();

        try {
            personaService.deleteExperiencia(id);

            serviceResult.setMessage("Experiencia Laboral eliminada");

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }
}
