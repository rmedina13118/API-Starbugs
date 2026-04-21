package com.api.capstone.model;

import com.api.capstone.model.enums.OrderState;
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
@Table(name = "pedido")
@Builder
public class Order {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_pedido")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_cliente",
            referencedColumnName = "id_cliente"
    )
    private Customer customer;

    @ManyToOne
    @JoinColumn(
            name = "id_estado",
            referencedColumnName = "id_estado"
    )
    private State state;

    @Column(name = "direccion_entrega")
    private String deliveryAddress;

    @Column(name = "fecha_hora")
    private LocalDateTime date;

    @Column(name = "total")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(
            name = "id_preparador",
            referencedColumnName = "id_persona"
    )
    private Person preparadorId;

    @ManyToOne
    @JoinColumn(
            name = "id_entregrador",
            referencedColumnName = "id_persona"
    )
    private Person entregadorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "modalidad")
    private OrderState status;
}
