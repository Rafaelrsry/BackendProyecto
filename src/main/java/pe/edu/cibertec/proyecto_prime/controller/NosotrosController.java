package pe.edu.cibertec.proyecto_prime.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.service.NosotrosService;
import pe.edu.cibertec.proyecto_prime.exception.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/nosotros")
public class NosotrosController {
    private NosotrosService nosotrosService;

    @GetMapping("")
    public ResponseEntity<List<Nosotros>> listarNosotros(){
        List<Nosotros> nosotrosList = new ArrayList<>(nosotrosService.listarNosotros());
        if(nosotrosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(nosotrosList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Nosotros> registrarNosotros(
            @RequestBody Nosotros nosotros
    ){
        return new ResponseEntity<>(
                nosotrosService.guardarNosotros(nosotros), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Nosotros> obtenerNosotroxId(
            @PathVariable Integer id){
        Nosotros nosotros = nosotrosService
                .obtenerNosotrosPorId(id).orElseThrow(
                        () -> new ResourceNotFoundException("Nosotros con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(nosotros, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nosotros> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Nosotros nosotros
    ){
        Nosotros newNosotros = nosotrosService.obtenerNosotrosPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con Id "
                        + id +" no existe"));
        newNosotros.setTitulo(nosotros.getTitulo());
        newNosotros.setDescripcion(nosotros.getDescripcion());
        return new ResponseEntity<>(
                nosotrosService.guardarNosotros(newNosotros),
                HttpStatus.OK);
    }


}
