package fr.uge.jee.hibernate.students;

public class Application {
    public static void main(String[] args) {
        AddressRepository ar = new AddressRepository();
        ar.create(1, "rue saint-bon", "Paris", "France");

        UniversityRepository ur = new UniversityRepository();
        ur.create("UGE");
        ur.delete(2L);
        ur.create("UGE-modified");

        CommentRepository cr = new CommentRepository();
        cr.create("Mr. Bouin", "mauvais élève");

        LectureRepository lr = new LectureRepository();
        lr.create("Mr. Bouin", "BackEnd");
        lr.delete(5L);
        lr.create("Mr. Bouin", "BackEnd-modified");

        StudentRepository sr = new StudentRepository();
        sr.create("Tom", "Redon", ar.get(1L).get(), ur.get(3L).get());

        sr.addComment(7L, cr.get(4L).get());
        sr.addLecture(7L, lr.get(6L).get());


        System.out.println(ar.getAll());
        System.out.println(ur.getAll());
        System.out.println(cr.getAll());
        System.out.println(lr.getAll());
        System.out.println(sr.getAll());

        sr.deleteComment(7L, cr.get(4L).get().getId());
        ur.create("ESIPE");
        sr.updateUniversity(7L, ur.get(8L).get());
        ar.create(6, "rue saint-bon", "Paris", "France");
        sr.updateAddress(7L, ar.get(9L).get());

        System.out.println(sr.getAll());

        System.out.println(sr.getStudentsOfLecture(lr.get(6L).get()));
        System.out.println(sr.getLecturesOfAStudent(7L));
    }
}
