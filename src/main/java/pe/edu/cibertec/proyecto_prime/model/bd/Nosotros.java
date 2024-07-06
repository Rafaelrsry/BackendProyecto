package pe.edu.cibertec.proyecto_prime.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "nosotros")
public class Nosotros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idnosotros;
    private String titulo;
    private String descripcion;

}
