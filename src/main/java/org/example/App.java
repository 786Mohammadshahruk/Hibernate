package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //Creating and configuring the hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure();

        //building the SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //creating Session
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(getEmployee());
        transaction.commit();
        session.close();

    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Rakesh");
        employee.setLastName("kumar");
        employee.setEmail("rakesh.kumar@gmail.com");
        return employee;
    }
}
