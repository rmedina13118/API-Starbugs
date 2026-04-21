package com.api.capstone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "receta")
@Builder
public class Recipe {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_receta")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_producto",
            referencedColumnName = "id_producto"
    )
    private Product product;

    @ManyToOne
    @JoinColumn(
            name = "id_insumo",
            referencedColumnName = "id_insumo"
    )
    private Material material;

    @Column(name = "cantidad")
    private BigDecimal quantity;
}
