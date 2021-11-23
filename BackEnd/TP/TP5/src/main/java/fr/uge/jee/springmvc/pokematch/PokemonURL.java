package fr.uge.jee.springmvc.pokematch;

public class PokemonURL {
    String name;
    String url;

    public PokemonURL() {}

    public PokemonURL(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PokemonURL{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
