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
@Table(name = "producto")
@Builder
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_producto")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_categoria",
            referencedColumnName = "id_categoria"
    )
    private Category category;
    @Column(name = "nombre")
    private String name;
    @Column(name = "precio")
    private BigDecimal price;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "disponibilidad")
    private Boolean availability;
}
