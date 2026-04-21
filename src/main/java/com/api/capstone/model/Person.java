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
@Table(name = "persona")
@Builder
public class Person {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_persona")
    private Integer id;

    @ManyToOne
    @JoinColumn(
            name = "id_role",
            referencedColumnName = "id_role"
    )
    private Role role;
    @Column(name = "nombre")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private String phone;
}
