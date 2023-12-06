package com.pokemon.tradecardgame.repositories;

import com.pokemon.tradecardgame.entities.LegalitiesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface LegalitiesRepository extends CrudRepository<LegalitiesEntity, UUID> {
}
