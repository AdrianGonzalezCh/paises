package com.paises.paises.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "ListaPaises") // Coincide con el nombre de la tabla en la base de datos
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Long idPais; // Coincide con el campo id_pais de la tabla

    @Column(name = "nombre_pais", nullable = false, length = 100)
    private String nombrePais; // Coincide con el campo nombre_pais

    @Column(name = "continente", nullable = false, length = 50)
    private String continente; // Coincide con el campo continente

    public Paises() {
    }

    public Paises(String nombrePais, String continente) {
        this.nombrePais = nombrePais;
        this.continente = continente;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }
}
