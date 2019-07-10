package daos;

import models.Pokemon;

import java.util.Set;

public interface PokemonDao {
    Set<Pokemon> getAllPokemon();
    Pokemon getPokemonById(Integer id);
    Pokemon getPokemonByName(String name);
    Boolean addPokemon(Pokemon pokemon);
    Boolean updatePokemon(Pokemon pokemon);
    Boolean deletePokemon(Integer id);



}
