package com.pokemon.tradecardgame.repositories;

import com.pokemon.tradecardgame.entities.LoginHistoricEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LoginHistoricRepository extends CrudRepository<LoginHistoricEntity, UUID> {
}
