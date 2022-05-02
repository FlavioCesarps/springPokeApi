package com.pokeapi.api.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OnePokemon {

    private String id;
    private String name;
    private String pic;
    private List<Type> types;
    private Sprites sprites;
    private Species species;
    private Integer height;
    private Integer order;
    private Integer weight;
    private Integer base_experience;
    private PokemonSpecies pokemonSpecies;
    private PreEvolution preEvolution;

}

