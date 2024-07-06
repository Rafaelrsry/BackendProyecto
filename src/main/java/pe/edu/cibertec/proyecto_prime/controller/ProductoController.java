package pe.edu.cibertec.proyecto_prime.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyecto_prime.exception.ResourceNotFoundException;
import pe.edu.cibertec.proyecto_prime.model.bd.Nosotros;
import pe.edu.cibertec.proyecto_prime.model.bd.Producto;
import pe.edu.cibertec.proyecto_prime.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>(productoService.listarProducto());
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.guardarProdcuto(producto), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoxId(
            @PathVariable Integer id){
        Producto producto = productoService
                .obtenerProductoXiD(id).orElseThrow(
                        () -> new ResourceNotFoundException("Producto con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Integer id,
            @RequestBody Producto producto
    ){
        Producto newProducto = productoService.obtenerProductoXiD(id)
                .orElseThrow(() -> new ResourceNotFoundException("La producto con Id "
                        + id +" no existe"));
      newProducto.setCantidad(producto.getCantidad());
      newProducto.setCodigo(producto.getCodigo());
        newProducto.setDescripcion(producto.getDescripcion());
        newProducto.setEstrellas(producto.getEstrellas());
        newProducto.setImagen(producto.getImagen());
        newProducto.setInventario(producto.getInventario());
        newProducto.setNombre(producto.getNombre());
        newProducto.setPrecio(producto.getPrecio());

        return new ResponseEntity<>(
                productoService.guardarProdcuto(newProducto),
                HttpStatus.OK);
    }

}
