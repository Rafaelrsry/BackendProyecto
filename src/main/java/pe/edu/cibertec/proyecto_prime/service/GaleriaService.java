package pe.edu.cibertec.proyecto_prime.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_prime.model.bd.Galeria;
import pe.edu.cibertec.proyecto_prime.model.bd.Producto;
import pe.edu.cibertec.proyecto_prime.repository.GaleriaRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GaleriaService implements IGaleriaService{

    private GaleriaRepository galeriaRepository;

    @Override
    public List<Galeria> listarGaleria() {
        return galeriaRepository.findAll();
    }

    @Override
    public Galeria guardargaleria(Galeria galeria) {
        return galeriaRepository.save(galeria);
    }

    @Override
    public Optional<Galeria> ObtenerxId(Integer id) {
        Optional<Galeria> galeria = galeriaRepository.findById(id);
        if(galeria.isEmpty()){
            return Optional.empty();
        }
        return galeria;
    }
}
