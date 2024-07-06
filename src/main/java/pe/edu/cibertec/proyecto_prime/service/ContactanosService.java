package pe.edu.cibertec.proyecto_prime.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_prime.model.bd.Contactanos;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.repository.ContactanosRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactanosService implements IContactanosService{

    private ContactanosRepository contactanosRepository;


    @Override
    public List<Contactanos> listarcontactanos() {
        return contactanosRepository.findAll();
    }

    @Override
    public Contactanos guardarContactanos(Contactanos contactanos) {
        return contactanosRepository.save(contactanos);
    }

    @Override
    public Optional<Contactanos> obtenerContactanosxId(Integer id) {
        Optional<Contactanos> contactanos = contactanosRepository.findById(id);
        if(contactanos.isEmpty()){
            return Optional.empty();
        }
        return contactanos;
    }
}
