package com.miage.altea.tp.pokemon_type_api.repository;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;

import java.util.List;
import java.util.Optional;

public interface PokemonTypeRepository {
    PokemonType findPokemonTypeById(int id);

    Optional<PokemonType> findPokemonTypeByName(String name);

    List<PokemonType> findAllPokemonType();

    List<PokemonType> findPokemonTypeByTypes(List<String> types);
}
