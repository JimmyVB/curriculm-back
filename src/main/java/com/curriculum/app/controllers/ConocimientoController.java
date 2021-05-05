package com.curriculum.app.controllers;

import com.curriculum.app.models.common.ServiceResult;
import com.curriculum.app.models.entity.Certificacion;
import com.curriculum.app.models.entity.Conocimiento;
import com.curriculum.app.models.services.IPersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/conocimiento")
public class ConocimientoController {

    private final Logger logger = LoggerFactory.getLogger(ConocimientoController.class);

    @Autowired
    private IPersonaService personaService;

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> create(@RequestBody Conocimiento conocimiento){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Conocimiento creada");
            serviceResult.setData(personaService.saveConocimiento(conocimiento));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);

    }

}
