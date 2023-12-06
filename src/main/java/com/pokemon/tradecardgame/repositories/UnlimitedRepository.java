package com.pokemon.tradecardgame.repositories;

import com.pokemon.tradecardgame.entities.UnlimitedEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UnlimitedRepository extends CrudRepository<UnlimitedEntity, UUID> {
}
