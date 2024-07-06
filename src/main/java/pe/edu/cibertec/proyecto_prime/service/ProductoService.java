package pe.edu.cibertec.proyecto_prime.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.model.bd.Producto;
import pe.edu.cibertec.proyecto_prime.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductoService implements IProductoService {
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProdcuto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> obtenerProductoXiD(Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if(producto.isEmpty()){
            return Optional.empty();
        }
        return producto;
    }
}
