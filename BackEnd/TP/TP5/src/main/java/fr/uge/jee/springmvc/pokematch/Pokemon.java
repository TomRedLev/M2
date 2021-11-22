package fr.uge.jee.springmvc.pokematch;

public class Pokemon {
    private String name;
    private String image = "";
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

    public String getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCounter() {
        this.counter += 1;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                '}';
    }
}
