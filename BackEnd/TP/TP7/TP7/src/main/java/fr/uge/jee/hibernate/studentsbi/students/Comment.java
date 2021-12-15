package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.*;

@Entity(name = "CommentBi")
@Table(name = "CommentsBi")
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "comment")
    private String comment;
    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    private Student student;

    public Comment() {}

    public Comment(String teacher, String comment) {
        this.teacher = teacher;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
