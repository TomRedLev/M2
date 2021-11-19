package fr.uge.jee.springmvc.pokematch;

public class Pokemon {
    private String name;
    private int counter = 0;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setCounter() {
        this.counter += 1;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                '}';
    }
}
