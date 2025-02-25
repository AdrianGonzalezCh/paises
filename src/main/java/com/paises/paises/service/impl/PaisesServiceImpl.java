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

    private final PaisesDao paisesDao;

    @Autowired
    public PaisesServiceImpl(PaisesDao paisesDao) {
        this.paisesDao = paisesDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paises> getPaises() {
        return paisesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paises getPais(Paises pais) {
        return paisesDao.findById(pais.getIdPais().longValue()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Paises pais) {
        paisesDao.save(pais);
    }

    @Override
    @Transactional
    public void delete(Paises pais) {
        paisesDao.delete(pais);
    }
}
