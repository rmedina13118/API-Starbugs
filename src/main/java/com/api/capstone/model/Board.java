package com.api.capstone.model;

import com.api.capstone.model.enums.TableState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mesa")
@Builder
public class Board {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id_mesa")
    private Integer id;
    @Column(name = "numero")
    private Integer number;
    @Column(name = "capacidad")
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private TableState state;
}
