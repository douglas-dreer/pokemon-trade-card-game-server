package com.pokemon.tradecardgame.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemon.tradecardgame.model.*;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Card {
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
