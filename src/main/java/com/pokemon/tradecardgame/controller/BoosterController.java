package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.model.Card;
import com.pokemon.tradecardgame.service.BoosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booster")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

    @GetMapping
    public ResponseEntity<List<Card>> createBooster(){
        return ResponseEntity.ok(boosterService.createBooster());
    }
}
