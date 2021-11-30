package fr.uge.jee.hibernate.employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    /**
     * Create an employee with the given information
     * @param firstName
     * @param lastName
     * @param salary
     * @return the id of the newly created employee
     */

    public long create(String firstName, String lastName, int salary) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        var employee = new Employee(firstName, lastName, salary);
        try{
            tx.begin();
            em.persist(employee);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return employee.getId();
    }

    /**
     * Remove the employee with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */

    public boolean delete(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            em.remove(em.find(Employee.class, id));
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    /**
     * Update the salary of the employee with the given id
     * @param id
     * @param salary
     * @return true if the removal was successful
     */

    public boolean update(long id, int salary) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var employee = em.find(Employee.class, id);
            employee.setSalary(salary);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }


    /**
     * Update the salary of the employee with the given id
     * @param id
     * @return true if the removal was successful
     */

    public boolean updateSalary(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        try{
            tx.begin();
            var employee = em.find(Employee.class, id);
            if (employee.getSalary() < 1000) {
                employee.setSalary(employee.getSalary() + 100);
            } else {
                employee.setSalary(employee.getSalary() + (employee.getSalary() / 10));
            }
            tx.commit();
        } catch (Exception e){
            tx.rollback();
            throw e;
        }
        em.close();
        return true;
    }

    /**
     * Retrieve the employee with the given id
     * @param id
     * @return the employee wrapped in an {@link Optional}
     */

    public Optional<Employee> get(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Student e WHERE e.id= :id");
        query.setParameter("id", id);
        Employee res = (Employee) query.getSingleResult();
        em.close();
        return Optional.of(res);
    }

    /**
     * Return the list of the employee in the DB
     */

    public List<Employee> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Student e");
        List<Employee> res = query.getResultList();
        em.close();
        return res;
    }

    List<Employee> getAllByFirstName(String firstName) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT e FROM Student e WHERE e.firstName= :fn");
        query.setParameter("fn", firstName);
        List<Employee> res = query.getResultList();
        em.close();
        return res;
    }
}
