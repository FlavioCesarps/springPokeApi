package com.pokeapi.api.pokemon.business.impl;

import com.pokeapi.api.pokemon.model.GetPokemon;
import com.pokeapi.api.pokemon.model.ListPokemon;
import com.pokeapi.api.pokemon.model.OnePokemon;
import com.pokeapi.api.pokemon.model.PokemonSpecies;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PokemonService {
    Mono<List<ListPokemon>> getAllPokemon();
    Mono<OnePokemon> getPokemon(String name);
    Mono<OnePokemon> getPokemonName(String name);
    Mono<PokemonSpecies> getPokemonSpecies(String name);
}
