package com.api.capstone.model;


import com.api.capstone.model.enums.TypeMovement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimiento_insumo")
@Builder
public class MaterialMovement {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_movimiento")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_insumo",
            referencedColumnName = "id_insumo"
    )
    private Material material;

    @ManyToOne
    @JoinColumn(
            name = "id_persona",
            referencedColumnName = "id_persona"
    )
    private Person person;

    @ManyToOne
    @JoinColumn(
            name = "id_pedido",
            referencedColumnName = "id_pedido"
    )
    private Order order;

    @Column(name = "cantidad")
    private BigDecimal stock;
    @Column(name = "fecha")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TypeMovement type;
}
