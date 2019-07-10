package models;

import daos.PokemonConcreteDao;

import java.util.ArrayList;

public class AppRunner {
    public static void main(String[] args) {
        PokemonConcreteDao pokemonConcreteDao = new PokemonConcreteDao();

        ArrayList pokemonList = (ArrayList<Pokemon>) pokemonConcreteDao.getAllPokemon();
        printPokemonList(pokemonList);

        System.out.println("\nPokemon list size: " + pokemonList.size() + "\n");

        Pokemon nidoking = new Pokemon(34, "Nidoking", "Poison", 50, "Purple");
        pokemonConcreteDao.addPokemon(nidoking);

        pokemonList = (ArrayList<Pokemon>) pokemonConcreteDao.getAllPokemon();
        System.out.println("\nPokemon list size: " + pokemonList.size() + "\n");

        System.out.println("\n\nNidoking:");
        printPokemon(pokemonConcreteDao.getPokemonById(34));

        nidoking.setColor("Blue");
        nidoking.setLevel(100);

        pokemonConcreteDao.updatePokemon(nidoking);
        System.out.println("\n\nUpdated Nidoking:");
        printPokemon(pokemonConcreteDao.getPokemonById(34));

        pokemonConcreteDao.deletePokemon(34);

        if (pokemonConcreteDao.getPokemonById(34) == null){
            System.out.println("*****Nidoking has been deleted*****");
        } else {
            System.out.println("*****Error*****");
        }

        pokemonList = (ArrayList<Pokemon>) pokemonConcreteDao.getAllPokemon();
        System.out.println("\nPokemon list size: " + pokemonList.size() + "\n");

    }


    public static void printPokemon(Pokemon pokemon){
        System.out.println("===================" +
                "\nId: " + pokemon.getId() +
                "\nName: " + pokemon.getName() +
                "\nElement: " + pokemon.getElement() +
                "\nLevel: " + pokemon.getLevel() +
                "\nColor: " + pokemon.getColor() +
                "\n===================\n"
        );
    }

    public static void printPokemonList(ArrayList<Pokemon> pokemonList){
        for (int i = 0; i < pokemonList.size(); i++){
            printPokemon(pokemonList.get(i));
        }
    }


}
