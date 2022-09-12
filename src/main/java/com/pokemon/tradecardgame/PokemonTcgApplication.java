package com.pokemon.tradecardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PokemonTcgApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonTcgApplication.class, args);
    }




}
