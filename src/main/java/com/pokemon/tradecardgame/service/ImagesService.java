package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.ImagesEntity;

import java.util.UUID;

public interface ImagesService {
    ImagesEntity save(ImagesEntity entity);
    ImagesEntity findById(UUID id);
}
