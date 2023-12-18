package org.hibernate.NamedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl {


    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void addEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmployee() {
        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.createNamedQuery("getEmployeeById", Employee.class);
            query.setParameter("emp_id", 1);
            System.out.println(query.uniqueResult());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void getEmployeeByNative() {
        try (Session session = sessionFactory.openSession()) {
            Query<Employee> query = session.createNamedQuery("findEmployeeWithNativeQuery", Employee.class);
            System.out.println(query.list());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
