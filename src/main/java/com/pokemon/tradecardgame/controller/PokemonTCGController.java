package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.Cards;
import com.pokemon.tradecardgame.model.Data;
import com.pokemon.tradecardgame.model.Set;
import com.pokemon.tradecardgame.model.Sets;
import com.pokemon.tradecardgame.service.PokemonTCGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webservice")
public class PokemonTCGController {
    @Autowired
    private PokemonTCGService service;

    @GetMapping(value = "/cards", params = "set", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardBySet(
            @RequestParam(name = "set") String setId,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(service.findAllCardBySetId(setId, page, pageSize));
    }

    @GetMapping(value = "/cards", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(service.findAllCardByName(name, page, pageSize));
    }

    @GetMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCards(String cardId, @RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize) {
        return ResponseEntity.ok(service.findAllCard(page, pageSize));
    }



    @GetMapping(value = "/cards/{cardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Data> findCardById(@PathVariable("cardId") String cardId) {
        return ResponseEntity.ok(service.findCardById(cardId));
    }

    @GetMapping(value = "/cards", params = {"set", "rarity"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> findCardByRarity(
            @RequestParam(name = "set") String setId,
            @RequestParam(name = "rarity", defaultValue = "COMMON") RarityEnum rarity,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ){
        return ResponseEntity.ok(service.findCardBySetAndRarity(setId, rarity, page, pageSize));
    }

    @GetMapping(value="/set")
    public ResponseEntity<Sets> listSet(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ) {
        return ResponseEntity.ok(service.findAllSet(page, pageSize));
    }

    @GetMapping(value="/set/{setId}")
    public ResponseEntity<Set> findSetById(String setId) {
        return ResponseEntity.ok(service.findSetById(setId));
    }

    @GetMapping(value = "/set", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sets> findSetByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(service.findSetByName(name, page, pageSize));
    }

    @GetMapping(value = "/set", params = "series", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sets> findSetBySerie(
            @RequestParam(name = "series") String name,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(service.findSetBySeries(name, page, pageSize));
    }

}
