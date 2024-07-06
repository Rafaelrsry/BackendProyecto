package pe.edu.cibertec.proyecto_prime.service;

import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;

import java.util.List;
import java.util.Optional;

public interface INosotrosService {
    List<Nosotros> listarNosotros();
    Nosotros guardarNosotros(Nosotros nosotros);
    Optional<Nosotros> obtenerNosotrosPorId(Integer id);
}
