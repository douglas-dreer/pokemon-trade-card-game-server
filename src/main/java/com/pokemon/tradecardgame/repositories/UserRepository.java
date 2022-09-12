package com.pokemon.tradecardgame.repositories;

import com.pokemon.tradecardgame.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, UUID>{
    UserEntity findByEmail(String email);
}
