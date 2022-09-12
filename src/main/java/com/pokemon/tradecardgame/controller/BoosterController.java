package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.model.Data;
import com.pokemon.tradecardgame.service.BoosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booster")
public class BoosterController {

    @Autowired
    private BoosterService boosterService;

    @GetMapping
    public ResponseEntity<List<Data>> createBooster(){
        return ResponseEntity.ok(boosterService.createBooster());
    }
}
