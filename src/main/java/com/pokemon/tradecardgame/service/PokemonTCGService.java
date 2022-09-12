package com.pokemon.tradecardgame.service;

import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonTCGService {

    private final RestTemplate restTemplate;
    private final String base_url = "https://api.pokemontcg.io/v2/";

    @Autowired
    public PokemonTCGService(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .rootUri("https://api.pokemontcg.io/v2/")
                .build();
    }

    public Cards findAllCard(int page, int pageSize) {
        ResponseEntity<Cards> responseEntity = restTemplate.getForEntity("/cards?page={page}&pageSize={pageSize}", Cards.class, page, pageSize);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }

    public Cards findAllCardBySetId(String setId, int page, int pageSize) {
        String uri = String.format("/cards?q=set.id:{setId}&page={page}&pageSize={pageSize}");
        ResponseEntity<Cards> responseEntity = restTemplate.getForEntity(uri, Cards.class, setId, page, pageSize);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }

    public Cards findAllCardByName(String name, int page, int pageSize) {
        String uri = String.format("/cards?q=name:{name}&page={page}&pageSize={pageSize}");
        ResponseEntity<Cards> responseEntity = restTemplate.getForEntity(uri, Cards.class, name, page, pageSize);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }

    public Data findCardById(String cardId) {
        ResponseEntity<Data> responseEntity = restTemplate.getForEntity("/cards/{cardId}", Data.class, cardId);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }

    public Cards findCardBySetAndRarity(String setId, RarityEnum rarity, int page, int pageSize) {
        ResponseEntity<Cards> responseEntity = restTemplate.getForEntity("/cards?q=set.id:{setId} rarity:{rarity}&page={page}&pageSize={pageSize}", Cards.class, setId, rarity.getName(), page, pageSize);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }

    public Sets findAllSet(int page, int pageSize) {
        ResponseEntity<Sets> responseEntity = restTemplate.getForEntity("/sets?page={page}&pageSize={pageSize}", Sets.class, page, pageSize);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }

    public Set findSetById(String setId) {
        ResponseEntity<Sets> responseEntity = restTemplate.getForEntity("/sets/{setId}", Sets.class, setId);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody().getData().get(0);
    }

    public Sets findSetByName(String setName, int page, int pageSize) {
        ResponseEntity<Sets> responseEntity = restTemplate.getForEntity("/sets?q=name:{setName}&page={page}&pageSize={pageSize}", Sets.class, setName, page, pageSize);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }

    public Sets findSetBySeries(String serieName, int page, int pageSize) {
        ResponseEntity<Sets> responseEntity = restTemplate.getForEntity("/sets?q=series:{serieName}&page={page}&pageSize={pageSize}", Sets.class, serieName, page, pageSize);
        return !responseEntity.getStatusCode().is2xxSuccessful() ? null : responseEntity.getBody();
    }


}
