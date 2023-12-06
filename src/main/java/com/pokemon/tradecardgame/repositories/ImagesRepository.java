package com.pokemon.tradecardgame.repositories;

import com.pokemon.tradecardgame.entities.ImagesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ImagesRepository extends CrudRepository<ImagesEntity, UUID> {
}
