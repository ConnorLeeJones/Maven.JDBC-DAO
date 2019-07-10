package daos;

import models.PokemonService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokemonDAOTest {
    private PokemonService pokemonService = new PokemonService();
    private Pokemon lapras;
    private Pokemon articuno;


    @Before
    public void setUp(){
        lapras = new Pokemon(131, "Lapras", "Water", 40, "Blue");
        articuno = pokemonService.getPokemonById(144);
    }


    @Test
    public void getIdLapras() {
        assertEquals(131, (int) lapras.getId());
    }

    @Test
    public void setIdLapras() {
        lapras.setId(500);
        assertEquals(500, (int) lapras.getId());
    }


    @Test
    public void getNameLapras() {
        assertEquals("Lapras", lapras.getName());
    }

    @Test
    public void setNameLapras() {
        lapras.setName("Lap");
        assertEquals("Lap", lapras.getName());
    }

    @Test
    public void getElementLapras() {
        assertEquals("Water", lapras.getElement());
    }

    @Test
    public void setElementLapras() {
        lapras.setElement("Ice");
        assertEquals("Ice", lapras.getElement());

    }

    @Test
    public void getLevelLapras() {
        assertEquals(40, (int) lapras.getLevel());
    }

    @Test
    public void setLevelLapras() {
        lapras.setLevel(50);
        assertEquals(50, (int) lapras.getLevel());
    }

    @Test
    public void getColorLapras() {
        assertEquals("Blue", lapras.getColor());
    }

    @Test
    public void setColorLapras() {
        lapras.setColor("Dark blue");
        assertEquals("Dark blue", lapras.getColor());
    }


    @Test
    public void getIdArticuno() {
        assertEquals(144, (int) articuno.getId());
    }


    @Test
    public void getNameArticuno() {
        assertEquals("Articuno", articuno.getName());
    }


    @Test
    public void getElementArticuno() {
        assertEquals("Ice", articuno.getElement());
    }


    @Test
    public void getLevelArticuno() {
        assertEquals(65, (int) articuno.getLevel());
    }


    @Test
    public void getColorArticuno() {
        assertEquals("Blue", articuno.getColor());
    }

}