package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Réponses à l'exercice 3 et 4 dans ce fichier.

@Entity(name = "StudentBi")
@Table(name = "StudentsBi")
public class Student {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REMOVE}, targetEntity = Address.class, orphanRemoval = true)
    private Address address;
    @ManyToOne(targetEntity = University.class)
    private University university;
    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH}, targetEntity = Comment.class, fetch = FetchType.EAGER, orphanRemoval=true)
    private List<Comment> comments;
    @ManyToMany(targetEntity = Lecture.class, fetch = FetchType.EAGER)
    private Set<Lecture> lectures;


    public Student() {}

    public Student(String firstName, String lastName, Address address, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.university = university;
        this.comments = new ArrayList<>();
        this.lectures = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addLecture(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public void deleteComment(long id) {
        for (var comment : comments) {
            if (id == comment.getId()) {
                comments.remove(comment);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", university=" + university +
                ", comments=" + comments +
                ", lectures=" + lectures +
                '}';
    }

}
