package fr.uge.jee.hibernate.students;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UniversityRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    public long create(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        var university = new University(name);
        try{
            tx.begin();
            em.persist(university);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return university.getId();
    }

    public boolean delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.find(University.class, id));
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public Optional<University> get(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT u FROM University u WHERE u.id= :id");
        query.setParameter("id", id);
        var res = (University) query.getSingleResult();
        em.close();
        return Optional.of(res);
    }

    public List<University> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT u FROM University u");
        List<University> res = query.getResultList();
        em.close();
        return res;
    }
}
