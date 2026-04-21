package com.api.capstone.model;

import com.api.capstone.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "factura")
@Builder
public class Bill {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_factura")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_pedido",
            referencedColumnName = "id_pedido"
    )
    private Order order;

    @Column(name = "fecha_emision")
    private LocalDateTime issueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private PaymentMethod paymentMethod;
}
