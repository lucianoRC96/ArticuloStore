package com.duoc.articulostore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetalleBoleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producto;
    private Double precioUnitario;
    private Integer cantidad;
}