package com.pokemon.tradecardgame.repositories;

import com.pokemon.tradecardgame.entities.SetsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SetsRepository extends CrudRepository<SetsEntity, UUID> {
    SetsEntity findByCode(String code);
    List<SetsEntity> findBySeries(String series);
}
