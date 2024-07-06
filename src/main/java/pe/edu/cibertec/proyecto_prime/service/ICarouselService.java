package pe.edu.cibertec.proyecto_prime.service;

import pe.edu.cibertec.proyecto_prime.model.bd.Carousel;
import pe.edu.cibertec.proyecto_prime.model.bd.Galeria;

import java.util.List;
import java.util.Optional;

public interface ICarouselService {

    List<Carousel> listarCarousel();
    Carousel guarda(Carousel carousel);
    Optional<Carousel> ObtenerxId(Integer id);
}
