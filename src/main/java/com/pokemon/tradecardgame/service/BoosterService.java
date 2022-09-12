package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.client.PokemonTCGClient;
import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.Card;
import com.pokemon.tradecardgame.model.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BoosterService {
    @Autowired
    private PokemonTCGClient pokemonTCGClient;

    private Map<RarityEnum, Cards> booster = new HashMap<>();

    @PostConstruct
    @Cacheable(value = "cardListByType")
    public void preloadData() {
        booster.put(RarityEnum.COMMON, pokemonTCGClient.findCardBySetAndRarityWithPagination("base1", RarityEnum.COMMON, 1, 250));
        booster.put(RarityEnum.UNCOMMON, pokemonTCGClient.findCardBySetAndRarityWithPagination("base1", RarityEnum.UNCOMMON, 1, 250));
        booster.put(RarityEnum.RARE, pokemonTCGClient.findCardBySetAndRarityWithPagination("base1", RarityEnum.RARE, 1, 250));
    }

    public List<Card> createBooster(){
        return Stream.of(
                createCardByType(RarityEnum.COMMON, 6),
                createCardByType(RarityEnum.UNCOMMON, 3),
                createCardByType(RarityEnum.RARE, 1)
        )
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }

    private List<Card> createCardByType(RarityEnum rarity, int quantidade) {
        List<Card> cardList = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= quantidade; i++) {
            int index = random.nextInt(0, booster.get(rarity).getCount());
            Card card = booster.get(rarity).getData().get(index);
            cardList.add(card);
        }

        return cardList;
    }
}
