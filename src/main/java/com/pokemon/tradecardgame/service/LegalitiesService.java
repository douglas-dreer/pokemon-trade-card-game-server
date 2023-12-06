package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.LegalitiesEntity;

import java.util.UUID;


public interface LegalitiesService {
    LegalitiesEntity save(LegalitiesEntity entity);
    LegalitiesEntity findById(UUID id);
}
