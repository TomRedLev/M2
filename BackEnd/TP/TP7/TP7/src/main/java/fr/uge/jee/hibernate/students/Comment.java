package fr.uge.jee.hibernate.students;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "comment")
    private String comment;

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

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
