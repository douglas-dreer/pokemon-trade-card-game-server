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
   private int page;
   private int pageSize;
   private int count;
   private int totalCount;
}
