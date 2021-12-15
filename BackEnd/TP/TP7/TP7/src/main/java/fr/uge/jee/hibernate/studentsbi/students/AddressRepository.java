package fr.uge.jee.hibernate.studentsbi.students;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class AddressRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    public long create(int number, String road, String city, String country) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        var address = new Address(number, road, city, country);
        try{
            tx.begin();
            em.persist(address);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return address.getId();
    }

    public boolean delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.find(Address.class, id));
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    public Optional<Address> get(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT a FROM AddressBi a WHERE a.id= :id");
        query.setParameter("id", id);
        var res = (Address) query.getSingleResult();
        em.close();
        return Optional.of(res);
    }

    public List<Address> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT a FROM AddressBi a");
        List<Address> res = query.getResultList();
        em.close();
        return res;
    }
}
