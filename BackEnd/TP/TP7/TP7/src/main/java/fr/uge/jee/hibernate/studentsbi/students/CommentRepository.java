package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CommentRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    public long create(String teacher, String comment) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        var comm = new Comment(teacher, comment);
        try{
            tx.begin();
            em.persist(comm);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return comm.getId();
    }

    public boolean delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.find(Comment.class, id));
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public Optional<Comment> get(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT c FROM CommentBi c WHERE c.id= :id");
        query.setParameter("id", id);
        var res = (Comment) query.getSingleResult();
        em.close();
        return Optional.of(res);
    }

    public List<Comment> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT c FROM CommentBi c");
        List<Comment> res = query.getResultList();
        em.close();
        return res;
    }
}
