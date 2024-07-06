package pe.edu.cibertec.proyecto_prime.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.model.bd.Rol;
import pe.edu.cibertec.proyecto_prime.model.bd.Usuario;
import pe.edu.cibertec.proyecto_prime.repository.RolRepository;
import pe.edu.cibertec.proyecto_prime.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        usuario.setGenero(usuario.getGenero());
        usuario.setApellidos(usuario.getApellidos());
        usuario.setDocumento(usuario.getDocumento());
        usuario.setEmail(usuario.getEmail());
        usuario.setNombres(usuario.getNombres());
        usuario.setNomusuario(usuario.getNomusuario());
        usuario.setRutafotoperfil(usuario.getRutafotoperfil());
        usuario.setActivo(true);
        Rol usuarioRol = rolRepository.findByNomrol("USER");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> ListarUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioxId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return Optional.empty();
        }
        return usuario;
    }




}
