package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;

import java.util.List;
import java.util.Optional;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);

    Optional<PokemonType> getPokemonTypeByName(String name);

    List<PokemonType> getAllPokemonTypes();

    List<PokemonType> getPokemonTypeFromTypes(List<String> types);
}