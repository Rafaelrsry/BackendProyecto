package pe.edu.cibertec.proyecto_prime.service;

import pe.edu.cibertec.proyecto_prime.model.bd.Galeria;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;

import java.util.List;
import java.util.Optional;

public interface IGaleriaService {

    List<Galeria> listarGaleria();
    Galeria guardargaleria(Galeria galeria);
    Optional<Galeria> ObtenerxId(Integer id);
}
