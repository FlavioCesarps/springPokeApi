package com.pokeapi.api.pokemon.business;

import com.pokeapi.api.pokemon.business.helper.WebClientPokemon;
import com.pokeapi.api.pokemon.business.impl.PokemonService;
import com.pokeapi.api.pokemon.model.*;
import com.pokeapi.api.pokemon.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("PokemonService")
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    private String URI = "/pokemon?limit=300";
    private String URIPOKEMON = "/pokemon";
    private String URISPECIES = "/pokemon-species";

    @Autowired
    private WebClientPokemon webClientPokemon;
    @Autowired
    private Utils utils;

    @Override
    public Mono<List<ListPokemon>> getAllPokemon() {
        return webClientPokemon
                .findAllPokemon(URI)
                .map(getPokemon -> getPokemon.getResults())
                .map(results -> utils.convertValuesPokemon(results));
    }

    @Override
    public Mono<OnePokemon> getPokemon(String name) {
        Mono<OnePokemon> onePokemonMono = getPokemonName(name)
                .flatMap(onePokemon -> getPokemonSpecies(onePokemon.getName())
                        .flatMap(pokemonSpecies -> {
                            onePokemon.setPokemonSpecies(pokemonSpecies);
                            return Mono.just(onePokemon);
                        }));
        return onePokemonMono
                .flatMap(onePokemon -> onePokemon.getPokemonSpecies().getEvolves_from_species() != null
                        ? getPokemonName(onePokemon.getPokemonSpecies().getEvolves_from_species().getName())
                        .flatMap(onePokemon1 ->{
                            onePokemon.setPreEvolution(new PreEvolution(onePokemon1.getName(),onePokemon1.getSprites()));
                            return Mono.just(onePokemon);
                        } ) : onePokemonMono);
    }

    @Override
    public Mono<OnePokemon> getPokemonName(String name) {
        return webClientPokemon
                .findPokemon(URIPOKEMON+"/"+name);
    }

    @Override
    public Mono<PokemonSpecies> getPokemonSpecies(String name) {
        return webClientPokemon.findPokemonSpecies(URISPECIES+"/"+name);
    }
}
