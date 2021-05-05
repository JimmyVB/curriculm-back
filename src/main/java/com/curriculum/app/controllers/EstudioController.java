package com.curriculum.app.controllers;

import com.curriculum.app.models.common.ServiceResult;
import com.curriculum.app.models.entity.Estudio;
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
@RequestMapping("/api/estudio")
public class EstudioController {

    private final Logger logger = LoggerFactory.getLogger(EstudioController.class);

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> create(@RequestBody Estudio estudio){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Estudio creado");
            serviceResult.setData(personaService.saveEstudio(estudio));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ServiceResult> update(@RequestBody Estudio estudio, @PathVariable Long id){

        ServiceResult serviceResult = new ServiceResult();
        try {
            Estudio estudioActual = personaService.findEstudioById(id);
            Estudio nuevoEstudio = null;

            estudioActual.setCarrera(estudio.getCarrera());
            estudioActual.setNombreInstitucion(estudio.getNombreInstitucion());
            estudioActual.setFechaFin(estudio.getFechaFin());

            nuevoEstudio = personaService.saveEstudio(estudioActual);

            serviceResult.setMessage("Estudio actualizado");
            serviceResult.setData(nuevoEstudio);

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

            serviceResult.setMessage("Estudio eliminado");

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }

}
