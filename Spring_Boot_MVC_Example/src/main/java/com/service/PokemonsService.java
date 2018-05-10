package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Pokemons;
import com.rep.PokemonsRep;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonsService {
    @Autowired
    private PokemonsRep pokemonsRep;

    public List<Pokemons> getAllPokemons(){
        List<Pokemons> pokemons = new ArrayList<>();
        pokemonsRep.findAll().forEach(pokemons::add);
        return pokemons;
    }

    public List<Pokemons> getAllPokemonsInStorage(int storage){
        List<Pokemons> pokemons = new ArrayList<>();
        pokemonsRep.findByStorage(storage).forEach(pokemons::add);
        return pokemons;
    }

    public Pokemons getPokemons(int id){
        return pokemonsRep.findOne(id);
    }

    public void addPokemons(Pokemons pokemons){
        pokemonsRep.save(pokemons);
    }

    public void updatePokemons(int id, Pokemons pokemons){
        pokemonsRep.save(pokemons);
    }

    public void deletePokemons(int id){
        pokemonsRep.delete(id);
    }
}
