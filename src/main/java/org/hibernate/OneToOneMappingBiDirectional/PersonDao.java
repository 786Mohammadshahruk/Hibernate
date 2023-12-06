package org.hibernate.OneToOneMappingBiDirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class PersonDao {

    static SessionFactory sessionFactory;

    static {
        Configuration configuration = new org.hibernate.cfg.Configuration();
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

    public void getPerson(int personId) {

        try (Session session = sessionFactory.openSession()) {
            Person person = session.get(Person.class, personId);
            System.out.println(person);
            System.out.println(person.getAddress());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updatePerson(int personId) {
        try (Session session = sessionFactory.openSession()) {

            Person person = session.get(Person.class, personId);

            if (person != null && person.getAddress() != null) {

                person.setName("1. Amit Kumar");

                Address address = person.getAddress();
                address.setStreet("2 Marin Drive");

                Transaction transaction = session.beginTransaction();
                //session.update(person);
                transaction.commit();
            } else {
                System.out.println("Person Is Not Present");
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deletePerson(int personId){
        try(Session session = sessionFactory.openSession()) {
            Person person = session.get(Person.class, personId);
            Transaction transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }


    public void getAddress(int address_id) {

        try (Session session = sessionFactory.openSession()) {
            Address address = session.get(Address.class, address_id);
            System.out.println(address);
            System.out.println(address.getPerson());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    //updateAddress()
    //deleteAddress()

}
