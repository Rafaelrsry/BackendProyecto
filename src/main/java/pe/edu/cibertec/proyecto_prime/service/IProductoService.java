package pe.edu.cibertec.proyecto_prime.service;

import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.model.bd.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> listarProducto();
    Producto guardarProdcuto(Producto producto);
    Optional<Producto> obtenerProductoXiD(Integer id);
}
