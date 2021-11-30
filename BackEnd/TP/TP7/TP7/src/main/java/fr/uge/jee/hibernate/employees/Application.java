package fr.uge.jee.hibernate.employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {
    public static void main(String[] args) {

        // Exercice 2 :
        /*
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
         */

        // Exercice 3 :
        EmployeeRepository er = new EmployeeRepository();
        er.create("Bob", "Moran", 500);
        er.create("Bob", "Dylan", 600);
        er.create("Lisa", "Simpson", 100);
        er.create("Marge", "Simpson", 1000);
        er.create("Homer", "Simpson", 450);
        er.delete(3);
        er.update(5, er.get(5).get().getSalary() + 100);
        System.out.println(er.getAll());

        for (var employee : er.getAll()) {
            if (employee.getSalary() < 550) {
                er.updateSalary(employee.getId());
            }
        }

        System.out.println(er.getAllByFirstName("Bob"));
    }
}
