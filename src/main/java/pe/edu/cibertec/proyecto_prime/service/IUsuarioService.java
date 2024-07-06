package pe.edu.cibertec.proyecto_prime.service;

import pe.edu.cibertec.proyecto_prime.model.bd.Producto;
import pe.edu.cibertec.proyecto_prime.model.bd.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario obtenerUsuarioPorNomUsuario(
            String nomusuario);

    Usuario guardarUsuario(Usuario usuario);
    List<Usuario> ListarUsuario();

    Optional<Usuario> obtenerUsuarioxId(Integer id);
}
