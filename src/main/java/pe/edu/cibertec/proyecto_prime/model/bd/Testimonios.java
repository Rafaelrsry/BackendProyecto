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
@Table(name = "testimonios")
public class Testimonios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtestimonio;
    @Column(length = 240)
    private String comentario;

    @OneToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
}
