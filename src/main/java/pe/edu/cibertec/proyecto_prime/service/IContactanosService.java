package pe.edu.cibertec.proyecto_prime.service;

import pe.edu.cibertec.proyecto_prime.model.bd.Contactanos;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;

import java.util.List;
import java.util.Optional;

public interface IContactanosService {
    List<Contactanos> listarcontactanos();
    Contactanos guardarContactanos(Contactanos contactanos);
    Optional<Contactanos> obtenerContactanosxId(Integer id);
}
