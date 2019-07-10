package daos;

import models.Pokemon;
import models.ConnectionClass;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PokemonConcreteDao implements PokemonDao {
    private Connection connection;
    private Statement stmt;
    private ResultSet rs;

    public PokemonConcreteDao(){
        connection = ConnectionClass.getConnection();
    }


    public Pokemon extractPokemonFromResultSet(ResultSet rs) throws SQLException{
        Pokemon pokemon = new Pokemon();

        pokemon.setId(rs.getInt("id"));
        pokemon.setName(rs.getString("name"));
        pokemon.setElement(rs.getString("element"));
        pokemon.setLevel(rs.getInt("level"));
        pokemon.setColor(rs.getString("color"));

        return pokemon;
    }




    public Set<Pokemon> getAllPokemon() {
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM pokemon");

            Set pokemon = new HashSet();

            while(rs.next()){
                Pokemon poke = extractPokemonFromResultSet(rs);
                pokemon.add(poke);
            }
            return pokemon;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Pokemon getPokemonById(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pokemon WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();


            if (rs.next()){
                return extractPokemonFromResultSet(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Set<Pokemon> getPokemonByLevel(Integer level) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pokemon WHERE level=?");
            ps.setInt(1, level);
            rs = ps.executeQuery();

            Set pokemon = new HashSet();

            while(rs.next()){
                Pokemon poke = extractPokemonFromResultSet(rs);
                pokemon.add(poke);
            }
            return pokemon;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public Pokemon getPokemonByName(String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pokemon WHERE name=?");
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()){
                return extractPokemonFromResultSet(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Boolean addPokemon(Pokemon pokemon) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pokemon VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, pokemon.getId());
            ps.setString(2, pokemon.getName());
            ps.setString(3, pokemon.getElement());
            ps.setInt(4, pokemon.getLevel());
            ps.setString(5, pokemon.getColor());

            int i = ps.executeUpdate();

            if (i == 1)
                return true;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean updatePokemon(Pokemon pokemon) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE pokemon name=?, element=?, level=?, color=? WHERE id=?");
            ps.setString(1, pokemon.getName());
            ps.setString(2, pokemon.getElement());
            ps.setInt(3, pokemon.getLevel());
            ps.setString(4, pokemon.getColor());
            ps.setInt(5, pokemon.getId());

            int i = ps.executeUpdate();

            if (i == 1)
                return true;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deletePokemon(Integer id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM pokemon WHERE id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();

            if (i == 1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
