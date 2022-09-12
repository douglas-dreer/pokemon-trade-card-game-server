package com.pokemon.tradecardgame.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tcgplayer {
    public String url;
    public String updatedAt;
    public Prices prices;
}
