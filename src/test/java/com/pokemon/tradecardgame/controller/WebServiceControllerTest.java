package com.pokemon.tradecardgame.controller;

import com.pokemon.tradecardgame.client.PokemonTCGClient;
import feign.FeignException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class WebServiceControllerTest {

    @InjectMocks
    private WebServiceController controller;

    @Mock
    private PokemonTCGClient client;

    @InjectMocks
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void mustReturnSuccessWhenListCardById() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/cards/{cardId}", "base1-1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListCardByIdWithNotFound() throws Exception {
        when(client.findCardById(anyString())).thenThrow(FeignException.class);

        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/cards/{cardId}", "value-invalid")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListCards() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/cards")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListCardBySet() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/cards")
                .param("set", "Base1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListCardBySerie() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/cards")
                .param("series", "Jungle")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListCardByName() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/cards")
                .param("name", "pikachu")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListCardByRarity() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/cards")
                .param("set", "base1")
                .param("rarity", "RARE")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListSet() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/set")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListSetById() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/set/{setId}", "base1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessButNotFoundWhenListSetById() throws Exception {
        when(client.findSetById(anyString())).thenThrow(FeignException.class);
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/set/{setId}", "value-invalid")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListSetByName() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/set")
                .param("name", "base")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void mustReturnSuccessWhenListSetBySerie() throws Exception {
        MockHttpServletRequestBuilder requestGet = MockMvcRequestBuilders
                .get("/ws/set")
                .param("series", "xy")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(requestGet)
                .andDo(print())
                .andExpect(status().isOk());
    }



}
