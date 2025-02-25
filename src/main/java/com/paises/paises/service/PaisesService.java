package com.paises.paises.service;

import com.paises.paises.domain.Paises;
import java.util.List;

public interface PaisesService {

    // Se obtiene un listado de países en un List
    public List<Paises> getPaises();

    // Se obtiene un país, a partir del id de un país
    public Paises getPais(Paises pais);

    // Inserta un nuevo país si el id está vacío, actualiza si NO está vacío
    public void save(Paises pais);

    // Se elimina el país que tiene el id pasado por parámetro
    public void delete(Paises pais);
}
