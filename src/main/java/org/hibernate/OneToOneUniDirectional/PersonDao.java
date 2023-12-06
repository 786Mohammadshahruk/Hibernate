package org.hibernate.OneToOneUniDirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonDao {

    static SessionFactory sessionFactory = null;

    static {
        //Creating and configuring the hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure();

        //building the SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    public void createPerson(Person person) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(person);
            transaction.commit();


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    public void deletePerson(int id) {
        try {
            Session session = sessionFactory.openSession();
            //fetch Person
            Person person = session.get(Person.class, id);

            Transaction transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    //Error
    public void deleteOrder(int id) {
        try {
            Session session = sessionFactory.openSession();
            //fetch Person
            Order order = session.get(Order.class, id);

            Transaction transaction = session.beginTransaction();
            session.delete(order);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
