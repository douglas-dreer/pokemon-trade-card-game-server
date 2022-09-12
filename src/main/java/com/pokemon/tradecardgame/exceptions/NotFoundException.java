package com.pokemon.tradecardgame.exceptions;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class NotFoundException extends Exception {
    private final String message = "Não foi encontrado nenhum registro com o valor: {}";
    public NotFoundException(Exception e, String value) {
        log.warn(message, value);
    }
}
