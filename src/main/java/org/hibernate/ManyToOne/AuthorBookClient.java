package org.hibernate.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AuthorBookClient {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void main(String[] args) {
        Author author = new Author();
        author.setName("Test1");

        Book book1 = new Book();
        book1.setAuthor(author);
        book1.setTitle("Test Title 1");

        Book book2 = new Book();
        book2.setAuthor(author);
        book2.setTitle("Test Title 1");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        session.save(book1);
        session.save(book2);
        transaction.commit();
        session.close();

    }

    //Get
    //Update
    //Delete
}
