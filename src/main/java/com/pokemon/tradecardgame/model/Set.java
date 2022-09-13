package com.pokemon.tradecardgame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
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
