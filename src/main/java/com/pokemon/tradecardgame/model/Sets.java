package com.pokemon.tradecardgame.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sets {
   private List<Set> data;
}
