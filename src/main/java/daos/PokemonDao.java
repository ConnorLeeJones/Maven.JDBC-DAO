package daos;

import models.Pokemon;

import java.util.List;

public interface PokemonDao {
    List<Pokemon> getAllPokemon();
    Pokemon getPokemonById(Integer id);
    Pokemon getPokemonByName(String name);
    Boolean addPokemon(Pokemon pokemon);
    Boolean updatePokemon(Pokemon pokemon);
    Boolean deletePokemon(Integer id);



}
