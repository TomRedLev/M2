package fr.uge.jee.springmvc.pokematchv1;

public class Pokemon {
    private String name;
    private Sprites sprites;
    private int counter = 0;

    public Pokemon(String name, Sprites sprites) {
        this.name = name;
        this.sprites = sprites;
    }

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon() {

    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounter() {
        this.counter += 1;
    }

    public void setSprites(Sprites image) {
        this.sprites = image;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                "sprites='" + sprites + '\'' +
                '}';
    }
}
