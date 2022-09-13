package com.pokemon.tradecardgame.client;

import com.pokemon.tradecardgame.enums.RarityEnum;
import com.pokemon.tradecardgame.model.Cards;
import com.pokemon.tradecardgame.model.Data;
import com.pokemon.tradecardgame.model.Sets;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pokemon-trade-card-game-client", url= "https://api.pokemontcg.io/v2/")
public interface PokemonTCGClient {

    @Cacheable(value = "all-cards")
    @RequestMapping(method = RequestMethod.GET, value = "/cards")
    Cards findAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @Cacheable(value = "all-cards-with-setId")
    @RequestMapping(method = RequestMethod.GET, value = "/cards?q=set.id:{setId}&page={page}&pageSize={pageSize}")
    Cards findAllBySetIdWithPagination(@RequestParam("setId") String setId, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(method = RequestMethod.GET, value = "/cards?q=name:{name}&page={page}&pageSize={pageSize}")
    Cards findAllCardByNameWithPagination(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(method = RequestMethod.GET, value = "/cards?q=set.series:{serieName}&page={page}&pageSize={pageSize}")
    Cards findCardBySerieWithPagination(@RequestParam("serieName") String serieName, @RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize);

    @RequestMapping(method = RequestMethod.GET, value = "/cards/{cardId}")
    Data findCardById(@RequestParam String cardId);

    @RequestMapping(method = RequestMethod.GET, value = "/cards?q=set.id:{setId} rarity:{rarity}&page={page}&pageSize={pageSize}")
    Cards findCardBySetAndRarityWithPagination(@RequestParam("setId") String setId, @RequestParam("rarity") RarityEnum rarity, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @Cacheable(value = "all-sets")
    @RequestMapping(method = RequestMethod.GET, value = "/sets?page={page}&pageSize={pageSize}")
    Sets findAllSetWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(method = RequestMethod.GET, value = "/sets/{setId}")
    Data findSetById(@RequestParam("setId") String setId);

    @RequestMapping(method = RequestMethod.GET, value = "/sets?q=name:{setName}&page={page}&pageSize={pageSize}")
    Sets findSetByNameWithPagination(@RequestParam("setName") String setName, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);

    @RequestMapping(method = RequestMethod.GET, value = "/sets?q=series:{serieName}&page={page}&pageSize={pageSize}")
    Sets findSetBySeriesWithPagination(@RequestParam("serieName") String serieName, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);


}
