package fr.uge.jee.hibernate.students;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class LectureRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    public long create(String teacher, String subject) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        var lecture = new Lecture(teacher, subject);
        try{
            tx.begin();
            em.persist(lecture);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return lecture.getId();
    }

    public boolean delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.find(Lecture.class, id));
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public Optional<Lecture> get(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT l FROM Lecture l WHERE l.id= :id");
        query.setParameter("id", id);
        var res = (Lecture) query.getSingleResult();
        em.close();
        return Optional.of(res);
    }

    public List<Lecture> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT l FROM Lecture l");
        List<Lecture> res = query.getResultList();
        em.close();
        return res;
    }
}
