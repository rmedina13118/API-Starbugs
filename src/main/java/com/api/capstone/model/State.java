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
@Table(name = "estado")
@Builder
public class State {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_estado")
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "descripcion")
    private String description;
}
