package pe.edu.cibertec.proyecto_prime.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_prime.exception.ResourceNotFoundException;
import pe.edu.cibertec.proyecto_prime.model.bd.Producto;
import pe.edu.cibertec.proyecto_prime.model.bd.Testimonios;
import pe.edu.cibertec.proyecto_prime.service.TestimoniosService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/testimonios")
public class TestimoniosController {

    private TestimoniosService testimoniosService;


    @GetMapping("")
    public ResponseEntity<List<Testimonios>> listarTestimonio(){
        List<Testimonios> testimoniosList = new ArrayList<>(testimoniosService.listarTestimonio());
        if(testimoniosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(testimoniosList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Testimonios> resgistrarTestimonio(
            @RequestBody Testimonios testimonios
    ){
        return new ResponseEntity<>(
                testimoniosService.guardartestimonio(testimonios), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Testimonios> obtenerxID(
            @PathVariable Integer id){
        Testimonios testimonios = testimoniosService
                .obtenerTestimoniosxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("Testimonio con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(testimonios, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Testimonios> actualizarTestimonios(
            @PathVariable Integer id,
            @RequestBody Testimonios testimonio
    ){
        Testimonios newTestimonio  = testimoniosService.obtenerTestimoniosxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La testimonio con Id "
                        + id +" no existe"));
        newTestimonio.setComentario(newTestimonio.getComentario());


        return new ResponseEntity<>(
                testimoniosService.guardartestimonio(newTestimonio),
                HttpStatus.OK);
    }

}
