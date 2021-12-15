package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "LectureBi")
@Table(name = "LecturesBi")
public class Lecture {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "subject")
    private String subject;
    @ManyToMany(targetEntity = Student.class)
    private List<Student> students = new ArrayList<>();

    public Lecture() {}

    public Lecture(String teacher, String subject) {
        this.teacher = teacher;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        return "subject{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
