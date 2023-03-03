package com.pokemon.tradecardgame.exceptions;

import com.pokemon.tradecardgame.enums.MessageErrorEnum;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
@NoArgsConstructor
public class PokemonTradeCardGameException extends Exception {

    public PokemonTradeCardGameException(MessageErrorEnum error) {
        log.warn(error.getMessage());
    }
    public PokemonTradeCardGameException(MessageErrorEnum error, Object object) {
        log.warn(error.getMessage(), object);
    }
}
