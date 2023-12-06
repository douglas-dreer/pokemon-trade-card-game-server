package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.LegalitiesEntity;
import com.pokemon.tradecardgame.repositories.LegalitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LegalitiesServiceImpl implements LegalitiesService {
    @Autowired
    private LegalitiesRepository repository;

    @Override
    public LegalitiesEntity save(LegalitiesEntity entity) {
        return repository.save(entity);
    }

    @Override
    public LegalitiesEntity findById(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
