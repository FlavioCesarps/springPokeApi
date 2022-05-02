package com.pokeapi.api.pokemon.expose;

import com.pokeapi.api.pokemon.business.PokemonServiceImpl;
import com.pokeapi.api.pokemon.model.ListPokemon;
import com.pokeapi.api.pokemon.model.OnePokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/pokemon")
public class PokemonController {
    @Autowired
    @Qualifier("PokemonService")
    private PokemonServiceImpl service;

    @GetMapping("/all")
    public Mono<ResponseEntity<List<ListPokemon>>> getAllPokemon(){
        return service.getAllPokemon()
                .flatMap(p -> Mono.just(ResponseEntity.ok().body(p)));
   }
    @GetMapping("/{name}")
    public Mono<ResponseEntity<OnePokemon>> getOnePokemon(@PathVariable("name") String name){
        return service.getPokemon(name)
                .flatMap(p -> Mono.just(ResponseEntity.ok().body(p)));
    }
}
