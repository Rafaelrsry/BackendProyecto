package pe.edu.cibertec.proyecto_prime.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.repository.NosotrosRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class NosotrosService implements INosotrosService{

    private NosotrosRepository nosotrosRepository;

    @Override
    public List<Nosotros> listarNosotros() {
        return nosotrosRepository.findAll();
    }

    @Override
    public Nosotros guardarNosotros(Nosotros nosotros) {
        return nosotrosRepository.save(nosotros);
    }

    @Override
    public Optional<Nosotros> obtenerNosotrosPorId(Integer id) {
        Optional<Nosotros> nosotros = nosotrosRepository.findById(id);
        if(nosotros.isEmpty()){
            return Optional.empty();
        }
        return nosotros;
    }


}
