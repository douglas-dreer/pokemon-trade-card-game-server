package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.ImagesEntity;
import com.pokemon.tradecardgame.repositories.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    private ImagesRepository repository;

    @Override
    public ImagesEntity save(ImagesEntity entity) {
        return repository.save(entity);
    }

    @Override
    public ImagesEntity findById(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
