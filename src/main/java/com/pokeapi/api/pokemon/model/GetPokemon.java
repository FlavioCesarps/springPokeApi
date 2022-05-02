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
public class GetPokemon {

    private Integer count;
    private String next;
    private String previous;
    private List<Results> results;

}

