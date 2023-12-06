package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.entities.SetsEntity;

import java.util.List;

public interface SetupService {
    void exportSetsFromWebSite(List<SetsEntity> entityList);
}
