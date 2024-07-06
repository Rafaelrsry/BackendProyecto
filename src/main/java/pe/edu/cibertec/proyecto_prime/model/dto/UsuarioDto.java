package pe.edu.cibertec.proyecto_prime.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class UsuarioDto {
    private Integer idusuario;
    private String Genero;
    private boolean activo;
    private String apellidos;
    private Integer documento;
    private String email;
    private String nombres;
    private String password;
    private String rutafotoperfil;

}
