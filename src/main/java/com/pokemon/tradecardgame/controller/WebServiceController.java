package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.client.PokemonTCGClient;
import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.exceptions.NotFoundException;
import com.pokemon.tradecardgame.model.Cards;
import com.pokemon.tradecardgame.model.Data;
import com.pokemon.tradecardgame.model.Sets;
import com.pokemon.tradecardgame.model.SubTypes;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ws")
@Log4j2
public class WebServiceController {
    @Autowired
    public PokemonTCGClient pokemonTCGClient;

    @GetMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCards(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize) {
        return ResponseEntity.ok(pokemonTCGClient.findAllWithPagination(page, pageSize));
    }

    @GetMapping(value = "/cards", params = "set", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardBySet(
            @RequestParam(name = "set") String setId,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ) {
        return  ResponseEntity.ok(pokemonTCGClient.findAllBySetIdWithPagination(setId, page, pageSize));
    }

    @GetMapping(value = "/cards", params = "series", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardBySerie(
            @RequestParam(name = "series") String series,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ) {
        return ResponseEntity.ok(pokemonTCGClient.findCardBySerieWithPagination(series, page, pageSize));
    }

    @GetMapping(value = "/cards", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(pokemonTCGClient.findAllCardByNameWithPagination(name, page, pageSize));
    }

    @GetMapping(value = "/cards/{cardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Data> findCardById(@PathVariable("cardId") String cardId) {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = ResponseEntity.ok(pokemonTCGClient.findCardById(cardId));
        } catch (Exception e) {
            new NotFoundException(e, cardId);
        }

        return responseEntity;
    }

    @GetMapping(value = "/cards", params = {"set", "rarity"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> findCardByRarity(
            @RequestParam(name = "set") String setId,
            @RequestParam(name = "rarity", defaultValue = "COMMON") RarityEnum rarity,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ){
        return ResponseEntity.ok(pokemonTCGClient.findCardBySetAndRarityWithPagination(setId, rarity, page, pageSize));
    }

    @GetMapping(value="/set")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Sets> listSet(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ) {
        return ResponseEntity.ok(pokemonTCGClient.findAllSetWithPagination(page, pageSize));
    }

    @GetMapping(value="/set/{setId}")
    public ResponseEntity<Data> findSetById(@PathVariable String setId) {
        ResponseEntity responseEntity;
        try {
            responseEntity = ResponseEntity.ok(pokemonTCGClient.findSetById(setId));
        } catch ( Exception e) {
            responseEntity = ResponseEntity.ok(null);
            log.warn("Não foi encontrado nenhum registro com o id: {}", setId);
        }
        return responseEntity;
    }

    @GetMapping(value = "/set", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sets> findSetByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(pokemonTCGClient.findSetByNameWithPagination(name, page, pageSize));
    }

    @GetMapping(value = "/set", params = "series", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Sets> findSetBySerie(
            @RequestParam(name = "series") String name,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(pokemonTCGClient.findSetBySeriesWithPagination(name, page, pageSize));
    }

    @GetMapping(value = "/subtypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTypes> listSubtypes() {
        return ResponseEntity.ok(pokemonTCGClient.findAllSubtypes());
    }

    @GetMapping(value = "/supertypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTypes> listSupertypes() {
        return ResponseEntity.ok(pokemonTCGClient.findAllSuperTypes());
    }

    @GetMapping(value = "/rarities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTypes> listRatities() {
        return ResponseEntity.ok(pokemonTCGClient.findAllRatities());
    }

    @GetMapping(value = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTypes> listTypes() {
        return ResponseEntity.ok(pokemonTCGClient.findAllTypes());
    }
}
