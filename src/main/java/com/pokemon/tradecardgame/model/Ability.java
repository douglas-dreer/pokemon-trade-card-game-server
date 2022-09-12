package com.pokemon.tradecardgame.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
    public String name;
    public String text;
    public String type;
}
