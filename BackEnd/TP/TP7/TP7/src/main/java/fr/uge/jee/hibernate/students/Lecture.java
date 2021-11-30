package fr.uge.jee.hibernate.students;

import javax.persistence.*;

@Entity
@Table(name = "Lectures")
public class Lecture {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "subject")
    private String subject;

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

    @Override
    public String toString() {
        return "subject{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
