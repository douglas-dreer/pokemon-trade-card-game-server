package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.client.PokemonTCGClient;
import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonTCGServiceImpl implements PokemonTCGService {
    @Autowired
    private PokemonTCGClient client;

    @Override
    public Cards findAllWithPagination(int page, int pageSize) {
        return client.findAllWithPagination(page, pageSize);
    }

    @Override
    public Cards listCardBySet(String setId, int page, int pageSize) {
        return client.findAllBySetIdWithPagination(setId, page, pageSize);
    }

    @Override
    public Cards listCardBySerie(String serie, int page, int pageSize) {
        return client.findCardBySerieWithPagination(serie, page, pageSize);
    }

    @Override
    public Cards listCardByName(String name, int page, int pageSize) {
        return client.findAllCardByNameWithPagination(name, page, pageSize);
    }

    @Override
    public Data findCardById(String cardId) {
        return client.findCardById(cardId);
    }

    @Override
    public Cards listCardByRarity(String setId, RarityEnum rarity, int page, int pageSize) {
        return client.findCardBySetAndRarityWithPagination(setId, rarity, page, pageSize);
    }

    @Override
    public Sets listSets(int page, int pageSize) {
        return client.findAllSetWithPagination(page, pageSize);
    }

    @Override
    public Data findSetById(String setId) {
        return client.findSetById(setId);
    }

    @Override
    public Sets findSetByName(String name, int page, int pageSize) {
        return client.findSetByNameWithPagination(name, page, pageSize);
    }

    @Override
    public Sets findSetBySerie(String series, int page, int pageSize) {
        return client.findSetBySeriesWithPagination(series, page, pageSize);
    }

    @Override
    public SubTypes listSubtypes() {
        return client.findAllSubtypes();
    }

    @Override
    public SuperTypes listSuperTypes() {
        return client.findAllSuperTypes();
    }

    @Override
    public Types listTypes() {
        return client.findAllTypes();
    }

    @Override
    public Rarities listRarities() {
        return client.findAllRatities();
    }
}
