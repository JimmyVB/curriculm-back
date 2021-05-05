package com.curriculum.app.controllers;

import com.curriculum.app.models.common.ServiceResult;
import com.curriculum.app.models.entity.Persona;
import com.curriculum.app.models.services.IPersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/informacion")
public class InformacionController {

    private final Logger logger = LoggerFactory.getLogger(InformacionController.class);

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> create(@RequestBody Persona persona){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Informacion creada");
            serviceResult.setData(personaService.save(persona));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ServiceResult> update(@RequestBody Persona persona, @PathVariable Long id){

        ServiceResult serviceResult = new ServiceResult();
        try {
            Persona personaActual = personaService.findById(id);
            Persona nuevaPersona = null;

            personaActual.setNombre(persona.getNombre());
            personaActual.setApellido(persona.getApellido());
            personaActual.setCorreo(persona.getCorreo());
            personaActual.setFechaNacimiento(persona.getFechaNacimiento());
            personaActual.setLugarNacimiento(persona.getLugarNacimiento());
            personaActual.setTelefono(persona.getTelefono());
            personaActual.setTituloProfesional(persona.getTituloProfesional());

            nuevaPersona = personaService.save(personaActual);

            serviceResult.setMessage("Informacion actualizada");
            serviceResult.setData(nuevaPersona);

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }

}
