package models;

import daos.Pokemon;
import models.PokemonService;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PokemonTest {
    PokemonService pokemonService = new PokemonService();

    @Before
    public void setUp(){
        if (pokemonService.getPokemonById(3) != null)
            pokemonService.deletePokemon(3);
        if (pokemonService.getPokemonById(6) != null)
            pokemonService.deletePokemon(6);
    }



    @Test
    public void getAllPokemon() {
        Set<Pokemon> pokemonHashSet = pokemonService.getAllPokemon();
        assertEquals(10, pokemonHashSet.size());
    }

    @Test
    public void getPokemonById() {
        Pokemon bulbasaur = pokemonService.getPokemonById(1);
        assertEquals("Bulbasaur", bulbasaur.getName());
    }

    @Test
    public void getPokemonByName() {
        Pokemon mew = pokemonService.getPokemonByName("Mew");
        assertEquals(151, (int) mew.getId());
    }

    @Test
    public void getPokemonByLevel(){
        Set<Pokemon> pokemonHashSet = pokemonService.getPokemonByLevel(100);
        assertEquals(2, pokemonHashSet.size());

    }

    @Test
    public void addPokemon() {
        Pokemon venusaur = new Pokemon(3, "Venusaur", "Grass", 50, "Green");
        pokemonService.addPokemon(venusaur);

        assertEquals(11, pokemonService.getAllPokemon().size());
        assertEquals(pokemonService.getPokemonById(3).getName(), "Venusaur");

        pokemonService.deletePokemon(3);
    }

    @Test
    public void updatePokemon() {
        Pokemon mew = pokemonService.getPokemonById(151);
        assertEquals((int) mew.getLevel(), 100);

        mew.setLevel(200);

        pokemonService.updatePokemon(mew);

        assertEquals((int) mew.getLevel(), 200);
    }

    @Test
    public void deletePokemon() {
        Pokemon charizard = new Pokemon(6, "Charizard", "Fire", 50, "Red");
        pokemonService.addPokemon(charizard);

        assertEquals(11, pokemonService.getAllPokemon().size());


        pokemonService.deletePokemon(6);
        assertEquals(10, pokemonService.getAllPokemon().size());
    }
}