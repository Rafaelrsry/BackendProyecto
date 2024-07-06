package pe.edu.cibertec.proyecto_prime.service;

import pe.edu.cibertec.proyecto_prime.model.bd.Producto;
import pe.edu.cibertec.proyecto_prime.model.bd.Testimonios;

import java.util.List;
import java.util.Optional;

public interface ITestimoniosService {


    List<Testimonios> listarTestimonio();
    Testimonios guardartestimonio(Testimonios testimonio);
    Optional<Testimonios> obtenerTestimoniosxId(Integer id);
}
