package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.Cards;
import com.pokemon.tradecardgame.model.Data;
import com.pokemon.tradecardgame.pojo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {
    @Autowired
    private PokemonTCGService webservice;

    public List<Card> createDeck() {
       return null;
    }



}
