package com.pokemon.tradecardgame.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cards {
    private List<Data> data;
    private int page;
    private int pageSize;
    private int count;
    private int totalCount;
}
