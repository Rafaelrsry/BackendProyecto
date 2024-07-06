package pe.edu.cibertec.proyecto_prime.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.model.bd.Producto;
import pe.edu.cibertec.proyecto_prime.model.bd.Testimonios;
import pe.edu.cibertec.proyecto_prime.repository.TestimoniosRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TestimoniosService implements ITestimoniosService{

    private TestimoniosRepository  testimoniosRepository;

    @Override
    public List<Testimonios> listarTestimonio() {
        return testimoniosRepository.findAll();
    }

    @Override
    public Testimonios guardartestimonio(Testimonios testimonios) {

        return testimoniosRepository.save(testimonios);
    }

    @Override
    public Optional<Testimonios> obtenerTestimoniosxId(Integer id) {

        Optional<Testimonios> testimonios = testimoniosRepository.findById(id);
        if(testimonios.isEmpty()){
            return Optional.empty();
        }
        return testimonios;
    }


}
