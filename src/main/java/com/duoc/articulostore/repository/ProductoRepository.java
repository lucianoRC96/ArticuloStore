package com.duoc.articulostore.repository;

import com.duoc.articulostore.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}
