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
@Table(name = "proveedor_insumo")
@Builder
public class SupplierMaterial {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_proveedor_insumo")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_proveedor",
            referencedColumnName = "id_proveedor"
    )
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(
            name = "id_insumo",
            referencedColumnName = "id_insumo"
    )
    private Material material;

    @Column(name = "precio_compra")
    private BigDecimal costPrice;
}
