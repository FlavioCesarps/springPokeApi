package com.pokeapi.api.pokemon.business.helper;

import com.pokeapi.api.pokemon.model.GetPokemon;
import com.pokeapi.api.pokemon.model.OnePokemon;
import com.pokeapi.api.pokemon.model.PokemonSpecies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientPokemon {
    @Autowired
    private WebClient webClient;

    public Mono<GetPokemon> findAllPokemon(String uri){
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(GetPokemon.class);
    }

    public Mono<OnePokemon> findPokemon(String uri){
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(OnePokemon.class);
    }

    public Mono<PokemonSpecies> findPokemonSpecies(String uri){
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(PokemonSpecies.class);
    }

}
