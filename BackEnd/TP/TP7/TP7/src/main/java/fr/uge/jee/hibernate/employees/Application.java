package fr.uge.jee.hibernate.employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = PersistenceUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var harry = new Employee("Harry","Potter", 1000);
            em.persist(harry);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
    }
}
