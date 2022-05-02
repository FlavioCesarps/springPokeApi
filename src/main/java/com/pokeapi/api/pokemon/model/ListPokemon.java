package com.pokeapi.api.pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.DocFlavor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListPokemon {
    private String id;
    private String pic;
    private String name;
}
