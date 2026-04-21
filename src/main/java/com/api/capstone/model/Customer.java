package com.api.capstone.model;

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
@Table(name = "cliente")
@Builder
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_cliente")
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "fecha_registro")
    private LocalDateTime register;
}
