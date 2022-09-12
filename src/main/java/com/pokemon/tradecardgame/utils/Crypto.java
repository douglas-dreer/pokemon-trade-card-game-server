package com.pokemon.tradecardgame.utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Crypto {
    public Crypto() {
    }

    public static String encode(String originValue){
        return Hashing.sha256()
                .hashString(originValue, StandardCharsets.UTF_8)
                .toString();
    }

    public static boolean verify(String valueFor, String valueFrom) {
        return valueFor == valueFrom;
    }
}
