package com.prueba.entiity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "persona_departamento")
public class PersonaDepartamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "persona_id_departamento")
    private Integer personaIdDepartamento;

    @Column(name = "departamento_id")
    private Integer departamentoId;

}
