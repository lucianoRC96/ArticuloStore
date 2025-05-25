package com.duoc.articulostore.Controller;

import com.duoc.articulostore.model.Producto;
import com.duoc.articulostore.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Producto agregar(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
}