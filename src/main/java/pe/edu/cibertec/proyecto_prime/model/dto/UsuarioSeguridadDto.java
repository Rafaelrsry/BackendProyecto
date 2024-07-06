package pe.edu.cibertec.proyecto_prime.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.edu.cibertec.proyecto_prime.model.bd.Rol;

import java.util.Set;

@AllArgsConstructor
@Getter
public class UsuarioSeguridadDto {
    private Integer idusuario;
    private String nomusuario;
    private String token;
    private Set<Rol>  roles;
}
