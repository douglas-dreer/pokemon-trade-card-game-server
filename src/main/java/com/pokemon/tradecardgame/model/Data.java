package com.pokemon.tradecardgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "data")
@JsonIgnoreProperties
public class Data {
    public String id;
    public String name;
    public String supertype;
    public ArrayList<String> subtypes;
    public String level;
    public String hp;
    public ArrayList<String> types;
    public String evolvesFrom;
    public ArrayList<Ability> abilities;
    public ArrayList<Attack> attacks;
    public ArrayList<Weakness> weaknesses;
    public ArrayList<String> retreatCost;
    public int convertedRetreatCost;
    public Set set;
    public String number;
    public String artist;
    public String rarity;
    public String flavorText;
    public ArrayList<Integer> nationalPokedexNumbers;
    public Legalities legalities;
    public Images images;
    public Tcgplayer tcgplayer;
    public Cardmarket cardmarket;
}

