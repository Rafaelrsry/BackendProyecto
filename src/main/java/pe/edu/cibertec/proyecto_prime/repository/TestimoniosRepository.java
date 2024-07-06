package pe.edu.cibertec.proyecto_prime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.proyecto_prime.model.bd.Testimonios;

@Repository
public interface TestimoniosRepository extends JpaRepository<Testimonios, Integer> {
}
