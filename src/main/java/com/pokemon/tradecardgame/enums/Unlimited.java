package com.pokemon.tradecardgame.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Unlimited {
    LEGAL("Legal"),
    NOT_LEGAL("Not Legal"),
    UNLIMITED("Unlimited");

    private final String value;

    public static Unlimited fromValue(String value) {
        for (Unlimited unlimited : Unlimited.values()) {
            if (unlimited.value.equalsIgnoreCase(value)) {
                return unlimited;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}