package org.hibernate.dao;

import org.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDao {
    static SessionFactory sessionFactory = null;

    static {
        //Creating and configuring the hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure();

        //building the SessionFactory
         sessionFactory = configuration.buildSessionFactory();
    }

    public void createEmployee(Employee employee) {

        //creating Session
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();
        session.close();
    }

    public Employee getEmployeeById(int employeeId) {

        //creating Session
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, employeeId);

        if (employee != null) {
            return employee;
        } else {
            System.out.println("Employee Does Not Exist with employee Id : " + employeeId);
        }
        return null;
    }
}
