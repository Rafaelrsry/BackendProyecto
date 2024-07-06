package pe.edu.cibertec.proyecto_prime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;

@Repository
public interface NosotrosRepository  extends JpaRepository<Nosotros, Integer> {
}
