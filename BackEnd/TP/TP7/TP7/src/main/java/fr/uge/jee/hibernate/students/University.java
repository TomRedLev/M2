package fr.uge.jee.hibernate.students;

import javax.persistence.*;

@Entity
@Table(name = "Universities")
public class University {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;

    public University() {}

    public University(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
