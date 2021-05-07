package com.curriculum.app.controllers;

import com.curriculum.app.models.common.ServiceResult;
import com.curriculum.app.models.entity.Persona;
import com.curriculum.app.models.services.IPersonaService;
import com.curriculum.app.models.services.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/informacion")
public class InformacionController {

    private final Logger logger = LoggerFactory.getLogger(InformacionController.class);

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IUploadFileService uploadFileService;

    @GetMapping("/{nombre}")
    public ResponseEntity<ServiceResult> ver(@PathVariable String nombre){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Informacion obtenida");
            serviceResult.setData(personaService.findByNombre(nombre));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ServiceResult> buscarPorId(@PathVariable Long id){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Informacion encontrada");
            serviceResult.setData(personaService.findById(id));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> create(@RequestBody Persona persona){

        ServiceResult serviceResult = new ServiceResult();

        try {

            serviceResult.setMessage("Informacion Creada");
            serviceResult.setData(personaService.save(persona));

        }catch (Exception ex){
            ex.printStackTrace();
            serviceResult.setError(ex.getMessage());
            serviceResult.setSuccess(false);
            return new ResponseEntity<>(serviceResult, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>(serviceResult, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
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

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){

        Map<String, Object> response = new HashMap<>();

        Persona persona = personaService.findById(id);

        if(!archivo.isEmpty()){

            String nombreArchivo = null;
            try {
                nombreArchivo = uploadFileService.copiar(archivo);
            } catch (IOException e) {
                response.put("mensaje", "Error al subir la imagen del cliente");
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoAnterior = persona.getFoto();
            uploadFileService.eliminar(nombreFotoAnterior);

            persona.setFoto(nombreArchivo);
            personaService.save(persona);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){

        Resource recurso = null;

        try {
            recurso = uploadFileService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+recurso.getFilename()+"\"");

        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }
}
