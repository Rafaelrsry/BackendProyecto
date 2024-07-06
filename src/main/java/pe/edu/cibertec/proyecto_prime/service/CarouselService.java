package pe.edu.cibertec.proyecto_prime.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_prime.model.bd.Carousel;
import pe.edu.cibertec.proyecto_prime.model.bd.Contactanos;
import pe.edu.cibertec.proyecto_prime.repository.CarouselRepository;
import pe.edu.cibertec.proyecto_prime.repository.ContactanosRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarouselService implements ICarouselService{
    private final ContactanosRepository contactanosRepository;
    private CarouselRepository carouselRepository;

    @Override
    public List<Carousel> listarCarousel() {
        return carouselRepository.findAll();
    }

    @Override
    public Carousel guarda(Carousel carousel) {
        return carouselRepository.save(carousel);
    }

    @Override
    public Optional<Carousel> ObtenerxId(Integer id) {
        Optional<Carousel> carousel = carouselRepository.findById(id);
        if(carousel.isEmpty()){
            return Optional.empty();
        }
        return carousel;
    }
}
