package fr.uge.jee.pokemon;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pokemon {
    @Id
    private String name;
    private int score = 1;

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
