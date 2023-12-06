package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.*;
import com.pokemon.tradecardgame.service.PokemonTCGServiceImpl;
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
    public PokemonTCGServiceImpl service;

    @GetMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCards(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize) {
        return ResponseEntity.ok(service.findAllWithPagination(page, pageSize));
    }

    @GetMapping(value = "/cards", params = "set", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardBySet(
            @RequestParam(name = "set") String setId,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ) {
        return  ResponseEntity.ok(service.listCardBySet(setId, page, pageSize));
    }

    @GetMapping(value = "/cards", params = "series", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardBySerie(
            @RequestParam(name = "series") String series,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ) {
        return ResponseEntity.ok(service.listCardBySerie(series, page, pageSize));
    }

    @GetMapping(value = "/cards", params = "name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cards> listCardByName(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize

    ) {
        return ResponseEntity.ok(service.listCardByName(name, page, pageSize));
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
        return ResponseEntity.ok(service.listCardByRarity(setId, rarity, page, pageSize));
    }

    @GetMapping(value="/set")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Sets> listSet(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "250") Integer pageSize
    ) {
        return ResponseEntity.ok(service.listSets(page, pageSize));
    }

    @GetMapping(value="/set/{setId}")
    public ResponseEntity<Data> findSetById(@PathVariable String setId) {
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
        return ResponseEntity.ok(service.findSetBySerie(name, page, pageSize));
    }

    @GetMapping(value = "/subtypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubTypes> listSubtypes() {
        return ResponseEntity.ok(service.listSubtypes());
    }

    @GetMapping(value = "/supertypes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperTypes> listSupertypes() {
        return ResponseEntity.ok(service.listSuperTypes());
    }

    @GetMapping(value = "/rarities", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rarities> listRatities() {
        return ResponseEntity.ok(service.listRarities());
    }

    @GetMapping(value = "/types", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Types> listTypes() {
        return ResponseEntity.ok(service.listTypes());
    }
}
