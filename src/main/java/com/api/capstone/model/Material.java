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
@Table(name = "insumo")
@Builder
public class Material {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_insumo")
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "stock_actual")
    private BigDecimal stock;
    @Column(name = "stock_minimo")
    private BigDecimal minStock;
    @Column(name = "precio_unidad")
    private BigDecimal price;
    @Column(name = "unidad_medida")
    private String unitMeasurement;
}
