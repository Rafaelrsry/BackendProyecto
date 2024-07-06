package pe.edu.cibertec.proyecto_prime.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_prime.exception.ResourceNotFoundException;
import pe.edu.cibertec.proyecto_prime.model.bd.Contactanos;
import pe.edu.cibertec.proyecto_prime.service.ContactanosService;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/contactanos")
public class ContactanosController {
    private ContactanosService contactanosService;


    @GetMapping("")
    public ResponseEntity<List<Contactanos>> listarContactanos(){
        List<Contactanos> ContactanosList = new ArrayList<>(contactanosService.listarcontactanos());
        if(ContactanosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ContactanosList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Contactanos> registrarContactanos(
            @RequestBody Contactanos contactanos
    ){
        return new ResponseEntity<>(
                contactanosService.guardarContactanos(contactanos), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Contactanos> obtenerNosotroxId(
            @PathVariable Integer id){
        Contactanos contactanos = contactanosService
                .obtenerContactanosxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("Nosotros con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(contactanos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contactanos> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Contactanos contactanos
    ){
        Contactanos newContactanos = contactanosService.obtenerContactanosxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con Id "
                        + id +" no existe"));
        newContactanos.setTitulo(contactanos.getTitulo());
        newContactanos.setDescripciontitulo(contactanos.getDescripciontitulo());
        newContactanos.setLlamanos(contactanos.getLlamanos());
        newContactanos.setDescripcionllamanos(contactanos.getDescripcionllamanos());
        newContactanos.setCorreo(contactanos.getCorreo());
        newContactanos.setDescripcioncorreo(contactanos.getDescripcioncorreo());
        return new ResponseEntity<>(
                contactanosService.guardarContactanos(newContactanos),
                HttpStatus.OK);


    }

}
