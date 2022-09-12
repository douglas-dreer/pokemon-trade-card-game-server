package com.pokemon.tradecardgame.model;

import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attack {
    public String name;
    public ArrayList<String> cost;
    public int convertedEnergyCost;
    public String damage;
    public String text;
}
