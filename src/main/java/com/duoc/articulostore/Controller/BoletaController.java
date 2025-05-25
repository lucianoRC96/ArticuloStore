package com.duoc.articulostore.Controller;

import com.duoc.articulostore.model.*;
import com.duoc.articulostore.repository.BoletaRepository;
import com.duoc.articulostore.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class BoletaController {
    private final ProductoRepository productoRepository;
    private final BoletaRepository boletaRepository;

    public BoletaController(ProductoRepository productoRepository, BoletaRepository boletaRepository) {
        this.productoRepository = productoRepository;
        this.boletaRepository = boletaRepository;
    }

    @PostMapping
    public Boleta comprar(@RequestBody List<CompraRequest> carrito) {
        List<DetalleBoleta> detalles = new ArrayList<>();
        double total = 0;
        for (CompraRequest req : carrito) {
            Producto prod = productoRepository.findById(req.getProductoId()).orElseThrow();
            DetalleBoleta detalle = new DetalleBoleta();
            detalle.setProducto(prod.getNombre());
            detalle.setPrecioUnitario(prod.getPrecio());
            detalle.setCantidad(req.getCantidad());
            detalles.add(detalle);
            total += prod.getPrecio() * req.getCantidad();
        }
        Boleta boleta = new Boleta();
        boleta.setDetalles(detalles);
        boleta.setTotal(total);
        return boletaRepository.save(boleta);
    }

    public static class CompraRequest {
        private Long productoId;
        private Integer cantidad;
        // getters y setters
        public Long getProductoId() { return productoId; }
        public void setProductoId(Long productoId) { this.productoId = productoId; }
        public Integer getCantidad() { return cantidad; }
        public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    }
}
