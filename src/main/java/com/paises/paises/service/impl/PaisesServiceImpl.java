package com.paises.paises.service.impl;

import com.paises.paises.dao.PaisesDao;
import com.paises.paises.domain.Paises;
import com.paises.paises.service.PaisesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisesServiceImpl implements PaisesService {
    
    @Autowired 
    private PaisesDao paisesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Paises> getPaises() {
        return paisesDao.findAll();
    }

    @Transactional(readOnly = true)
    public Paises getPais(Paises pais) {
        return paisesDao.findById(pais.getIdPais()).orElse(null);
    }

    @Transactional
    public void save(Paises pais) {
        paisesDao.save(pais);
    }

    @Transactional
    public void delete(Paises pais) {
        paisesDao.delete(pais);
    }
}
