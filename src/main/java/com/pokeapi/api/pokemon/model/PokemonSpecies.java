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
public class PokemonSpecies {

    private List<Color> egg_groups;
    private Color habitat;
    private Color evolves_from_species;
    private Color shape;
    private Color color;



}
