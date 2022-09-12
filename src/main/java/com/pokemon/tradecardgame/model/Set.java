package com.pokemon.tradecardgame.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Set {
    public String id;
    public String name;
    public String series;
    public int printedTotal;
    public int total;
    public Legalities legalities;
    public String ptcgoCode;
    public String releaseDate;
    public String updatedAt;
    public Images images;
}
