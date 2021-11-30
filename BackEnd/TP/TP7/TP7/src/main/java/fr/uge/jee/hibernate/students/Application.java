package fr.uge.jee.hibernate.students;

public class Application {
    public static void main(String[] args) {
        AddressRepository ar = new AddressRepository();
        ar.create(1, "rue saint-bon", "Paris", "France");

        UniversityRepository ur = new UniversityRepository();
        ur.create("UGE");

        CommentRepository cr = new CommentRepository();
        cr.create("Mr. Bouin", "mauvais élève");

        LectureRepository lr = new LectureRepository();
        lr.create("Mr. Bouin", "BackEnd");

        StudentRepository sr = new StudentRepository();
        sr.create("Tom", "Redon");


        System.out.println(ar.getAll());
        System.out.println(ur.getAll());
        System.out.println(cr.getAll());
        System.out.println(lr.getAll());
        System.out.println(sr.getAll());
    }
}
