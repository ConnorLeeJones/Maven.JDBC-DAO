package daos;

public class Pokemon {
    private Integer id;
    private String name;
    private String element;
    private Integer level;
    private String color;

    public Pokemon() {}

    public Pokemon(Integer id, String name, String element, Integer level, String color) {
        this.id = id;
        this.name = name;
        this.element = element;
        this.level = level;
        this.color = color;
    }

    public Pokemon(String name, String element, Integer level, String color) {
        this.name = name;
        this.element = element;
        this.level = level;
        this.color = color;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
