package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.SetsEntity;
import com.pokemon.tradecardgame.repositories.SetsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
public class SetsServiceImpl implements SetsService {
    @Autowired
    private SetsRepository repository;

    @Override
    public List<SetsEntity> findAll() {
        return (List<SetsEntity>) Optional.of(repository.findAll()).orElse(new ArrayList<>());
    }

    @Override
    public SetsEntity findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SetsEntity findByCode(String code) {
        return Optional.of(repository.findByCode(code)).orElse(null);
    }

    @Override
    public List<SetsEntity> findBySerie(String serie) {
        return Optional.of(repository.findBySeries(serie)).orElse(new ArrayList<>());
    }

    @Override
    public SetsEntity save(SetsEntity entity) {
        return Optional.of(repository.save(entity)).orElse(null);
    }

    @Override
    public List<SetsEntity> saveAll(List<SetsEntity> entityList) {
        return (List<SetsEntity>) repository.saveAll(entityList);
    }
}
