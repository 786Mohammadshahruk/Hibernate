package org.hibernate.NamedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDaoImpl {


    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void addPerson(Person person) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(person);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getPerson() {
        try (Session session = sessionFactory.openSession()) {
            //HQL  "From Employee"
            String SQL = "Select * from person_table";
            Query<Person> query = session.createNativeQuery(SQL, Person.class);
            List<Person> personList = query.list();
            personList.forEach(System.out::println);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getPersonNameAndDOB() {
        try (Session session = sessionFactory.openSession()) {
            //HQL  "From Employee"
            String SQL = "Select name,dob from person_table";
            Query<Object[]> query = session.createNativeQuery(SQL);
            for (Object[] obj : query.list()) {
                System.out.println(obj[0]);
                System.out.println(obj[1]);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
