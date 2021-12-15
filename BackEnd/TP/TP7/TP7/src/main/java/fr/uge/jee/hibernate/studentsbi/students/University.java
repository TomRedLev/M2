package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "UniversityBi")
@Table(name = "UniversitiesBi")
public class University {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

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
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
