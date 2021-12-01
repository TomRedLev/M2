package fr.uge.jee.hibernate.students;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    public long create(String firstName, String lastName, Address address) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        var student = new Student(firstName, lastName, address);
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
        Query query = em.createQuery("SELECT s FROM Student s WHERE s.id= :id");
        query.setParameter("id", id);
        Student res = (Student) query.getSingleResult();
        em.close();
        return Optional.of(res);
    }

    public List<Student> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT s FROM Student s");
        List<Student> res = query.getResultList();
        em.close();
        return res;
    }
}
