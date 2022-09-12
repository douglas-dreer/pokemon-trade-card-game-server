package com.pokemon.tradecardgame.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum RarityEnum {
    AMAZING_RARE("Amazing Rare"),
    COMMON("Common"),
    LEGEND("LEGEND"),
    PROMO("Promo"),
    RARE("Rare"),
    RARE_ACE("Rare ACE"),
    RARE_BREAK("Rare BREAK"),
    RARE_HOLO("Rare Holo"),
    RARE_HOLO_EX("Rare Holo EX"),
    RARE_HOLO_GX("Rare Holo GX"),
    RARE_HOLO_LVX("Rare Holo LV.X"),
    RARE_HOLO_START("Rare Holo Star"),
    RARE_HOLO_V("Rare Holo V"),
    RARE_HOLO_VMAX("Rare Holo VMAX"),
    RARE_HOLO_PRIME("Rare Prime"),
    RARE_PRISM_STAR("Rare Prism Star"),
    RARE_RAINBOW ("Rare Rainbow"),
    RARE_SECRET("Rare Secret"),
    RARE_SHINING("Rare Shining"),
    RARE_SHINY("Rare Shiny"),
    RARE_SHINY_GX("Rare Shiny GX"),
    RARE_ULTRA("Rare Ultra"),
    UNCOMMON("Uncommon");

    private String name;


    RarityEnum(String name) {
        this.name = name;
    }
}
