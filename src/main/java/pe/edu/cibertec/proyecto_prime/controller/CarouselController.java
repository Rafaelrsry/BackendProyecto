package pe.edu.cibertec.proyecto_prime.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_prime.exception.ResourceNotFoundException;
import pe.edu.cibertec.proyecto_prime.model.bd.Carousel;
import pe.edu.cibertec.proyecto_prime.model.bd.Contactanos;
import pe.edu.cibertec.proyecto_prime.service.CarouselService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/carousel")
public class CarouselController {

    private CarouselService carouselService;

    @GetMapping("")
    public ResponseEntity<List<Carousel>> listarCarousel(){
        List<Carousel> carouselList = new ArrayList<>(carouselService.listarCarousel());
        if(carouselList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carouselList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Carousel> registrarCarousel(
            @RequestBody Carousel carousel
    ){
        return new ResponseEntity<>(
                carouselService.guarda(carousel), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Carousel> obtenerNosotroxId(
            @PathVariable Integer id){
        Carousel carousel = carouselService
                .ObtenerxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("Carousel con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(carousel, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carousel> actualizarCarousel(
            @PathVariable Integer id,
            @RequestBody Carousel carousel
    ){
        Carousel newCarousel = carouselService.ObtenerxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La carousel con Id "
                        + id +" no existe"));
           newCarousel.setRutaimagen(carousel.getRutaimagen());
        return new ResponseEntity<>(
                carouselService.guarda(newCarousel),
                HttpStatus.OK);


    }

}
