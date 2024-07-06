package pe.edu.cibertec.proyecto_prime.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_prime.exception.ResourceNotFoundException;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.model.bd.Usuario;
import pe.edu.cibertec.proyecto_prime.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> listarUsuario(){
        List<Usuario> usuarioList = new ArrayList<>(usuarioService.ListarUsuario());
        if(usuarioList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @PostMapping("/guardar-usuario")
    public ResponseEntity<Usuario> registrarUser(
            @RequestBody Usuario usuario
    ){
        return new ResponseEntity<>(
                usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioxId(
            @PathVariable Integer id){
        Usuario usuario = usuarioService
                .obtenerUsuarioxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("Uusario con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable Integer id,
            @RequestBody Usuario usuario
    ){
        Usuario nuevoUsario = usuarioService.obtenerUsuarioxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La usuario con Id "
                        + id +" no existe"));
        nuevoUsario.setGenero(usuario.getGenero());
        nuevoUsario.setNomusuario(usuario.getNomusuario());
        nuevoUsario.setActivo(true);
        nuevoUsario.setApellidos(usuario.getApellidos());
        nuevoUsario.setDocumento(usuario.getDocumento());
        nuevoUsario.setEmail(usuario.getEmail());
        nuevoUsario.setNombres(usuario.getNombres());
        nuevoUsario.setNomusuario(usuario.getNomusuario());
        nuevoUsario.setPassword(usuario.getPassword());
        nuevoUsario.setRutafotoperfil(usuario.getRutafotoperfil());

        return new ResponseEntity<>(
                usuarioService.guardarUsuario(nuevoUsario),
                HttpStatus.OK);
    }

}
