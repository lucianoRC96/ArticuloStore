package com.duoc.articulostore.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DetalleBoleta> detalles;
}
