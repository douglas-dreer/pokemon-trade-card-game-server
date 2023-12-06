package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.client.PokemonTCGClient;
import com.pokemon.tradecardgame.entities.LegalitiesEntity;
import com.pokemon.tradecardgame.entities.SetsEntity;
import com.pokemon.tradecardgame.entities.UnlimitedEntity;
import com.pokemon.tradecardgame.enums.Unlimited;
import com.pokemon.tradecardgame.model.Set;
import com.pokemon.tradecardgame.model.Sets;
import com.pokemon.tradecardgame.service.SetupServiceImpl;
import com.pokemon.tradecardgame.utils.Converter;
import lombok.extern.log4j.Log4j2;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/setup")
@Log4j2
public class SetupController {
    @Autowired
    public PokemonTCGClient pokemonTCGClient;

    @Autowired
    private SetupServiceImpl service;
    @GetMapping("/export/sets")
    public ResponseEntity<String> exportSetsFromSite() {
        Sets resultPagination = pokemonTCGClient.findAllSetWithPagination(1, 250);

        List<SetsEntity> setsEntityList = resultPagination.getData().stream().map( (set) -> {
            SetsEntity entity = Converter.convertTo(set, SetsEntity.class);
            Unlimited unlimited = Unlimited.fromValue(set.getLegalities().getUnlimited());
            entity.setLegalities(new LegalitiesEntity(null, unlimited));
            return entity;
        }).toList();

        service.exportSetsFromWebSite(setsEntityList);

        return ResponseEntity.ok("Exportação realizada com sucesso.");
    }

}
