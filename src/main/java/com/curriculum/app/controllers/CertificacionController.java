package com.curriculum.app.controllers;

import com.curriculum.app.models.common.ServiceResult;
import com.curriculum.app.models.entity.Certificacion;
import com.curriculum.app.models.entity.Estudio;
import com.curriculum.app.models.services.IPersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/certifacion")
public class CertificacionController {

    private final Logger logger = LoggerFactory.getLogger(CertificacionController.class);

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> create(@RequestBody Certificacion certificacion){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Certificacion creada");
            serviceResult.setData(personaService.saveCertificacion(certificacion));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ServiceResult> update(@RequestBody Certificacion certificacion, @PathVariable Long id){

        ServiceResult serviceResult = new ServiceResult();
        try {
            Certificacion certificacionActual = personaService.findCertificacionById(id);
            Certificacion nuevoCertificacion = null;

            certificacionActual.setNombre(certificacion.getNombre());
            certificacionActual.setFechaCertifacion(certificacion.getFechaCertifacion());

            nuevoCertificacion = personaService.saveCertificacion(certificacionActual);

            serviceResult.setMessage("Certificacion actualizada");
            serviceResult.setData(nuevoCertificacion);

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
            personaService.deleteCertificacion(id);

            serviceResult.setMessage("Certificacion eliminada");

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }

}
