package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    public long create(String firstName, String lastName, Address address, University university) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        var student = new Student(firstName, lastName, address, university);
        try{
            tx.begin();
            em.persist(student);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return student.getId();
    }

    public boolean delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.find(Student.class, id));
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public Optional<Student> get(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT s FROM StudentBi s WHERE s.id= :id");
        query.setParameter("id", id);
        Student res = (Student) query.getSingleResult();
        em.close();
        return Optional.of(res);
    }

    public List<Student> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT s FROM StudentBi s");
        List<Student> res = query.getResultList();
        em.close();
        return res;
    }

    public boolean addLecture(long id, Lecture lecture) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var student = em.find(Student.class, id);
            student.addLecture(lecture);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public boolean updateUniversity(long id, University university) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var student = em.find(Student.class, id);
            student.setUniversity(university);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public boolean updateAddress(long id, Address address) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var student = em.find(Student.class, id);
            student.setAddress(address);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public boolean addComment(long id, Comment comment) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var student = em.find(Student.class, id);
            student.addComment(comment);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public boolean deleteComment(long id, long comment_id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var student = em.find(Student.class, id);
            student.deleteComment(comment_id);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public List<Student> getStudentsOfLecture(Lecture lecture) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var lid = lecture.getId();
        var query = em.createQuery( "SELECT s FROM StudentBi AS s LEFT JOIN FETCH s.lectures AS l WHERE l.id = :lid ", Student.class).setParameter("lid", lid).getResultList();
        em.close();
        return query;
    }

    public List<Lecture> getLecturesOfAStudent(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT s.lectures FROM StudentBi s WHERE s.id= :id");
        query.setParameter("id", id);
        var res = query.getResultList();
        em.close();
        return res;
    }
}
