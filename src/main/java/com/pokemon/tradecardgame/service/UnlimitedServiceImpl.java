package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.UnlimitedEntity;
import com.pokemon.tradecardgame.repositories.UnlimitedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UnlimitedServiceImpl implements UnlimitedService {
    @Autowired
    private UnlimitedRepository repository;

    @Override
    public UnlimitedEntity save(UnlimitedEntity unlimited) {
        return repository.save(unlimited);
    }

    @Override
    public UnlimitedEntity findById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<UnlimitedEntity> list() {
        return (List<UnlimitedEntity>) repository.findAll();
    }
}
