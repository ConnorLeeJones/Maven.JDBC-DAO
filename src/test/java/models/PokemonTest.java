package models;

import daos.PokemonConcreteDao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class PokemonTest {
    private PokemonConcreteDao pokemonConcreteDao = new PokemonConcreteDao();

    @Before
    public void setUp(){
        if (pokemonConcreteDao.getPokemonById(3) != null)
            pokemonConcreteDao.deletePokemon(3);
        if (pokemonConcreteDao.getPokemonById(6) != null)
            pokemonConcreteDao.deletePokemon(6);
    }



    @Test
    public void getAllPokemon() {
        List<Pokemon> pokemonList = pokemonConcreteDao.getAllPokemon();
        assertEquals(10, pokemonList.size());
    }

    @Test
    public void getPokemonById() {
        Pokemon bulbasaur = pokemonConcreteDao.getPokemonById(1);
        assertEquals("Bulbasaur", bulbasaur.getName());
    }

    @Test
    public void getPokemonByName() {
        Pokemon mew = pokemonConcreteDao.getPokemonByName("Mew");
        assertEquals(151, (int) mew.getId());
    }

    @Test
    public void getPokemonByLevel(){
        Set<Pokemon> pokemonHashSet = pokemonConcreteDao.getPokemonByLevel(65);
        assertEquals(3, pokemonHashSet.size());

    }

    @Test
    public void addPokemon() {
        Pokemon venusaur = new Pokemon(3, "Venusaur", "Grass", 50, "Green");
        pokemonConcreteDao.addPokemon(venusaur);

        assertEquals(11, pokemonConcreteDao.getAllPokemon().size());
        assertEquals(pokemonConcreteDao.getPokemonById(3).getName(), "Venusaur");

        pokemonConcreteDao.deletePokemon(3);
    }

    @Test
    public void updatePokemon() {
        Pokemon mew = pokemonConcreteDao.getPokemonById(151);

        mew.setLevel(100);
        pokemonConcreteDao.updatePokemon(mew);

        assertEquals(100, (int) pokemonConcreteDao.getPokemonById(151).getLevel());

        mew.setLevel(200);
        pokemonConcreteDao.updatePokemon(mew);

        assertEquals(200, (int) pokemonConcreteDao.getPokemonById(151).getLevel());
    }

    @Test
    public void deletePokemon() {
        Pokemon charizard = new Pokemon(6, "Charizard", "Fire", 50, "Red");
        pokemonConcreteDao.addPokemon(charizard);

        assertEquals(11, pokemonConcreteDao.getAllPokemon().size());


        pokemonConcreteDao.deletePokemon(6);
        assertEquals(10, pokemonConcreteDao.getAllPokemon().size());
    }
}