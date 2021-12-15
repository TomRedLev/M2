package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "AddressBi")
@Table(name = "AddressesBi")
public class Address {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "number")
    private int number;
    @Column(name = "road")
    private String road;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    public Address() {}

    public Address(int number, String road, String city, String country) {
        this.number = number;
        this.road = road;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number=" + number +
                ", road='" + road + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
