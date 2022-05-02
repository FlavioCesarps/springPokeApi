package com.pokeapi.api.pokemon.utils;

import com.pokeapi.api.pokemon.model.ListPokemon;
import com.pokeapi.api.pokemon.model.Results;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {
    public List<ListPokemon> convertValuesPokemon(List<Results> resultsList){

        List<ListPokemon> listPokemonLis = new ArrayList<ListPokemon>();


        resultsList.forEach(results ->{
            ListPokemon listPokemon = new ListPokemon();
            listPokemon.setId(splitUrlIdPokemon(results.getUrl()));
            listPokemon.setName(results.getName());
            listPokemon.setPic("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+listPokemon.getId()+".png");
            listPokemonLis.add(listPokemon);
        } );

        return listPokemonLis;
    }

    public String splitUrlIdPokemon(String url){
        String[] uri = url.split("/");
        return uri[6];
    }

}
