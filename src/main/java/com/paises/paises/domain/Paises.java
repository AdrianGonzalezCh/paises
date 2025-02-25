package com.paises.paises.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor  // Genera constructor vacío
@AllArgsConstructor // Genera constructor con todos los atributos
@Entity
@Table(name = "listapaises") // Asegurar que coincide con la tabla en MySQL
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Integer idPais; // Se cambió de Long a Integer para coincidir con MySQL

    @Column(name = "nombre_pais", nullable = false, length = 100)
    private String nombrePais;

    @Column(name = "continente", nullable = false, length = 50)
    private String continente;
}
