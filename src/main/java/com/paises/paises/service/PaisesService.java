package com.paises.paises.service;

import com.paises.paises.domain.Paises;
import java.util.List;

public interface PaisesService {
    
    // Se obtiene un listado de países en un List
    public List<Paises> getPaises();
    
    // CRUD
    // Se obtiene un país, a partir del id de un país
    public Paises getPais(Paises pais);
    
    // Se inserta un nuevo país si el id del país está vacío
    // Se actualiza un país si el id del país NO está vacío
    public void save(Paises pais);
    
    // Se elimina el país que tiene el id pasado por parámetro
    public void delete(Paises pais);
}
