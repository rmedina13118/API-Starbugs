package com.api.capstone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proveedor")
@Builder
public class Supplier {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_proveedor")
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "calle")
    private String street;
    @Column(name = "numero_calle")
    private Integer numberStreet;
    @Column(name = "ciudad")
    private String city;
    @Column(name = "codigo_postal")
    private Integer zipCode;
}
