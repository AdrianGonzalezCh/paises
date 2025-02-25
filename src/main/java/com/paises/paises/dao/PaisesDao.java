package com.paises.paises.dao;

import com.paises.paises.domain.Paises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisesDao extends JpaRepository<Paises, Long> {

}
