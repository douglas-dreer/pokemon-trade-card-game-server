package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.Cards;
import com.pokemon.tradecardgame.model.Data;
import com.pokemon.tradecardgame.pojo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BoosterService {
    @Autowired
    private  PokemonTCGService webservice;

    private Map<RarityEnum, Cards> booster = new HashMap<>();

    @PostConstruct
    @Cacheable
    public void preloadData() {
        booster.put(RarityEnum.COMMON, webservice.findCardBySetAndRarity("base1", RarityEnum.COMMON, 1, 250));
        booster.put(RarityEnum.UNCOMMON, webservice.findCardBySetAndRarity("base1", RarityEnum.UNCOMMON, 1, 250));
        booster.put(RarityEnum.RARE, webservice.findCardBySetAndRarity("base1", RarityEnum.RARE, 1, 250));
    }

    public List<Data> createBooster(){
        return Stream.of(
                createCardByType(RarityEnum.COMMON, 6),
                createCardByType(RarityEnum.UNCOMMON, 3),
                createCardByType(RarityEnum.RARE, 1)
        )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    private List<Data> createCardByType(RarityEnum rarity, int quantidade) {
        List<Data> cardList = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= quantidade; i++) {
            int index = random.nextInt(0, booster.get(rarity).getCount());
            Data card = booster.get(rarity).getData().get(index);
            cardList.add(card);
        }

        return cardList;
    }
}
