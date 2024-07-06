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
@Table(name = "contactanos")
public class Contactanos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcontactanos;
    private String titulo;
    private String descripciontitulo;
    private String llamanos;
    private String descripcionllamanos;
    private String correo;
    private String descripcioncorreo;


}
