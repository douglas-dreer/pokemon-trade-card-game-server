package com.pokemon.tradecardgame.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "data")
@JsonInclude(NON_NULL)
public class SuperTypes {
    private List<String> data;
}
