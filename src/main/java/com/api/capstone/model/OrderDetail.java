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
@Table(name = "detalle_pedido")
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_detalle")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_pedido",
            referencedColumnName = "id_pedido"
    )
    private Order order;

    @ManyToOne
    @JoinColumn(
            name = "id_producto",
            referencedColumnName = "id_producto"
    )
    private Product product;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_unitario")
    private BigDecimal unitPrice;
}
