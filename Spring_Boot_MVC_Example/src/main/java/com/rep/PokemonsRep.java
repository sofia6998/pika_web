package com.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entity.Pokemons;

import java.util.List;

@Repository
public interface PokemonsRep extends JpaRepository<Pokemons, Integer> {

    List<Pokemons> findByStorage(int storage);
}
