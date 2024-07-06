package pe.edu.cibertec.proyecto_prime.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_prime.exception.ResourceNotFoundException;
import pe.edu.cibertec.proyecto_prime.model.bd.Contactanos;
import pe.edu.cibertec.proyecto_prime.model.bd.Galeria;
import pe.edu.cibertec.proyecto_prime.service.GaleriaService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/galeria")
public class GaleriaController {

    private final GaleriaService galeriaService;

    @GetMapping("")
    public ResponseEntity<List<Galeria>> listarGaleria(){
        List<Galeria> GaleriaList = new ArrayList<>(galeriaService.listarGaleria());
        if(GaleriaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(GaleriaList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Galeria> registrarGaleria(
            @RequestBody Galeria galeria
    ){
        return new ResponseEntity<>(
                galeriaService.guardargaleria(galeria), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Galeria> obtenerNosotroxId(
            @PathVariable Integer id){
        Galeria galeria = galeriaService
                .ObtenerxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("Galeria con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(galeria, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Galeria> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Galeria galeria
    ){
        Galeria newGaleria = galeriaService.ObtenerxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La galeria con Id "
                        + id +" no existe"));
        newGaleria.setRutaimagen(galeria.getRutaimagen());

        return new ResponseEntity<>(
                galeriaService.guardargaleria(newGaleria),
                HttpStatus.OK);


    }
}
