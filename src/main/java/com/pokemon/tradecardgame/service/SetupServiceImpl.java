package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.SetsEntity;
import com.pokemon.tradecardgame.repositories.SetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SetupServiceImpl implements SetupService{
    @Autowired
    private SetsRepository setsRepository;

    @Override
    public void exportSetsFromWebSite(List<SetsEntity> entityList) {
        setsRepository.saveAll(entityList);
    }
}
