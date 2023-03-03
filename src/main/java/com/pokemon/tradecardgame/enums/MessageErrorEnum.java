package com.pokemon.tradecardgame.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum MessageErrorEnum {
    NOT_EQUALS("Os parâmetros enviados não são iguais. [{} {}]"),
    NOT_FOUND("Não foi encontrado nenhum registro com o valor: {}");

    private String message;
}
