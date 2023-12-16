package org.hibernate.HQL_JOIN;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.awt.*;


public class HqlJoinDao {


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

    public void getAddress(int addressId) {

        try (Session session = sessionFactory.openSession()) {

            String HQL = "From Address address LEFT OUTER JOIN Fetch address.employee where address.id =:addressId";
            Query<Address> query = session.createQuery(HQL, Address.class);
            query.setParameter("addressId", addressId);
            Address address = query.uniqueResult();
            System.out.println(address);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}

/*
SELECT column_name(s)
FROM table1
LEFT JOIN table2
ON table1.column_name = table2.column_name;
 */
