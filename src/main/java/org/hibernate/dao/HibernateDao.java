package org.hibernate.dao;

import org.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Student;

import java.util.Objects;

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
        Employee employee1 = session.get(Employee.class, employeeId);
        System.out.println("Employee 1 : " + employee1);

        Employee employee2 = session.get(Employee.class, 1);
        System.out.println("Employee 2 : " + employee2);
        employee2.getContactNumber();

        if (employee1 != null) {
            return employee1;
        } else {
            System.out.println("Employee Does Not Exist with employee Id : " + employeeId);
        }
        return null;
    }

    public void updateEmployee(int employeeId, String firstName) {

        Session session = sessionFactory.openSession();
        //fetch Student based on employeeId
        Employee employee = session.get(Employee.class, employeeId);

        if (employee != null) {
            System.out.println("Fetched Employee : " + employee);
            employee.setFirstName(firstName);

            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } else {
            System.out.println(" Employee Does Not Exist with Provided EmployeeId : " + employeeId);
        }
        session.close();
    }

    public void updateEmployee(int employeeId, Employee newEmployee) {
        Session session = null;
        try {
            session = sessionFactory.openSession();

            //fetch Student based on employeeId
            Employee employee = session.get(Employee.class, employeeId);
            System.out.println("Fetched Employee : " + employee);

            if (Objects.nonNull(employee)) {
                employee.setContactNumber(newEmployee.getContactNumber());
                employee.setLastName(newEmployee.getLastName());
                Transaction transaction = session.beginTransaction();
                //Updating Employee
                session.update(employee);
                transaction.commit();
            } else {
                System.out.println(" Employee Does Not Exist with Provided EmployeeId : " + employeeId);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteByEmployeeId(int employeeId) {

        try (Session session = sessionFactory.openSession()) {
            //fetch Student based on employeeId
            Employee employee = session.get(Employee.class, employeeId);
            System.out.println("Fetched Employee : " + employee);

            if (employee != null) {
                Transaction transaction = session.beginTransaction();
                session.delete(employee);
                transaction.commit();
            } else {
                System.out.println(" Employee Does Not Exist with Provided EmployeeId : " + employeeId);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void getEmployeeByIdUsingLoad(int employeeId) {

        Session session = sessionFactory.openSession();
        Employee employee = session.load(Employee.class, employeeId);
        System.out.println("Employee : " + employee);

    }


    public void saveStudent(Student student) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
