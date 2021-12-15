package fr.uge.jee.hibernate.studentsbi.students;

public class Application {
    public static void main(String[] args) {
        AddressRepository ar = new AddressRepository();
        UniversityRepository ur = new UniversityRepository();
        CommentRepository cr = new CommentRepository();
        LectureRepository lr = new LectureRepository();
        StudentRepository sr = new StudentRepository();

        ar.create(1, "rue saint-bon", "Paris", "France");
        ur.create("UGE");
        ur.delete(2L);
        ur.create("UGE-modified");
        cr.create("Mr. Bouin", "mauvais élève");
        lr.create("Mr. Bouin", "BackEnd");
        lr.delete(5L);
        lr.create("Mr. Bouin", "BackEnd-modified");
        lr.create("Mr. Carayol", "Design Pattern");
        sr.create("Tom", "Redon", ar.get(1L).get(), ur.get(3L).get());
        sr.addComment(8L, cr.get(4L).get());
        sr.addLecture(8L, lr.get(6L).get());
        sr.addLecture(8L, lr.get(7L).get());

        System.out.println(sr.getAll());
        sr.deleteComment(8L, cr.get(4L).get().getId());
        ur.create("ESIPE");
        sr.updateUniversity(8L, ur.get(9L).get());
        ar.create(6, "rue saint-bon", "Paris", "France");
        sr.updateAddress(8L, ar.get(10L).get());
        System.out.println(sr.getAll());

        ar.create(2, "rue du test", "Serris", "France");
        ur.create("université-test");
        cr.create("Mr. Carayol", "bon élève");
        sr.create("Julien", "Mercier", ar.get(11L).get(), ur.get(12L).get());
        sr.addComment(14L, cr.get(13L).get());
        sr.addLecture(14L, lr.get(7L).get());

        System.out.println(sr.getStudentsOfLecture(lr.get(6L).get()));
        System.out.println(sr.getLecturesOfAStudent(8L));

        sr.delete(8L);
        sr.delete(14L);
    }
}
