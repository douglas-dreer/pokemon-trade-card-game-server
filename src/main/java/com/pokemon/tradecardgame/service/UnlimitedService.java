package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.UnlimitedEntity;

import java.util.List;
import java.util.UUID;

public interface UnlimitedService {
    UnlimitedEntity save(UnlimitedEntity unlimited);
    UnlimitedEntity findById(UUID id);
    List<UnlimitedEntity> list();
}
