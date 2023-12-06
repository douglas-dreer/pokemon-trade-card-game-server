package com.pokemon.tradecardgame.service;


import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.*;

public interface PokemonTCGService {
    Cards findAllWithPagination(int page, int pageSize);
    Cards listCardBySet(String setId, int page, int pageSize);
    Cards listCardBySerie(String serie, int page, int pageSize);
    Cards listCardByName(String name, int page, int pageSize);
    Data findCardById(String cardId);
    Cards listCardByRarity(String setId, RarityEnum rarity, int page, int pageSize);
    Sets listSets(int page, int pageSize);
    Data findSetById(String setId);
    Sets findSetByName(String name, int page, int pageSize);
    Sets findSetBySerie(String series, int page, int pageSize);

    SubTypes listSubtypes();
    SuperTypes listSuperTypes();
    Types listTypes();
    Rarities listRarities();

}
