package com.example.dncinema.service.typeFilm.impl;

import com.example.dncinema.model.TypeFilm;
import com.example.dncinema.repository.ITypeFilmRepository;
import com.example.dncinema.service.typeFilm.ITypeFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeFilmService implements ITypeFilmService {
    @Autowired
    private ITypeFilmRepository iTypeFilmRepository;

    @Override
    public List<TypeFilm> findAll() {
        return iTypeFilmRepository.findAll();
    }
}
