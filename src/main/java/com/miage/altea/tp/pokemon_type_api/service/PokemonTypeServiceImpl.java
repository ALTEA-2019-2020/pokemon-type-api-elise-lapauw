package com.miage.altea.tp.pokemon_type_api.service;

import com.miage.altea.tp.pokemon_type_api.bo.PokemonType;
import com.miage.altea.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.miage.altea.tp.pokemon_type_api.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    @Autowired
    public PokemonTypeRepository pokemonTypeRepository;
    @Autowired
    public TranslationRepository translationRepository;

    public PokemonTypeServiceImpl() {
    }


    @Override
    public PokemonType getPokemonType(int id) {
        PokemonType pokemonType = pokemonTypeRepository.findPokemonTypeById(id);
        pokemonType.setName(this.translationRepository.getPokemonName(id, LocaleContextHolder.getLocale()));
        return pokemonType;
    }

    @Override
    public PokemonType getPokemonTypeByName(String name) {
        return pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes() {
        //this.pokemonTypeRepository.findAllPokemonType();
        ArrayList<PokemonType> pokemonsTranslated = new ArrayList<>(pokemonTypeRepository.findAllPokemonType());
        for (PokemonType pokemonType : pokemonsTranslated ){
            pokemonType.setName(this.translationRepository.getPokemonName(pokemonType.getId(), LocaleContextHolder.getLocale()));
        }
        pokemonsTranslated.sort(Comparator.comparing(PokemonType::getId));
        System.out.println(pokemonsTranslated);
        return pokemonsTranslated;
    }

    @Override
    public List<PokemonType> getPokemonTypeFromTypes(List<String> types) {
        return pokemonTypeRepository.findPokemonTypeByTypes(types);
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypeRepository getPokemonTypeRepository() {
        return pokemonTypeRepository;
    }


    @Autowired // TODO : not sure
    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }

}
