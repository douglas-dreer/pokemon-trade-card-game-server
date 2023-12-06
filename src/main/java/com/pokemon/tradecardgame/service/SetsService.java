package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.SetsEntity;

import java.util.List;
import java.util.UUID;

public interface SetsService {
    List<SetsEntity> findAll();
    SetsEntity findById(UUID id);
    SetsEntity findByCode(String code);

    List<SetsEntity> findBySerie(String serie);

    SetsEntity save(SetsEntity entity);
    List<SetsEntity> saveAll(List<SetsEntity> entityList);
}
