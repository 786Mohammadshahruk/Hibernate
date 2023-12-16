package org.hibernate.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class EmployeeDao {

    public static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void addEmployee(List<Employee> employees) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            /*employees.forEach(i -> {
                session.persist(i);
            });*/
            employees.forEach(session::persist);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public List<Employee> getAllEmployee() {
        try (Session session = sessionFactory.openSession()) {

            String HQL = "FROM Employee";

            Query<Employee> query = session.createQuery(HQL, Employee.class);

            List<Employee> employeeList = query.list();
            //List<Employee> employeeList = query.getResultList();
            if (employeeList != null && !employeeList.isEmpty()) {
                return employeeList;
            } else {
                System.out.println("Employee Not Found");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void getEmployee(String name) {
        try (Session session = sessionFactory.openSession()) {

            String HQL = "FROM Employee Where name=:employeeName";

            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter("employeeName", name);

            List<Employee> employeeList = query.list();

            if (employeeList != null) {
                System.out.println(employeeList);
            } else {
                System.out.println("Employee Not Found");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmployeeBySalaryAndName(double salary, String name) {
        try (Session session = sessionFactory.openSession()) {

            String HQL = "FROM Employee Where name=:employeeName AND salary=:sal";

            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter("employeeName", name);
            query.setParameter("sal", salary);

            List<Employee> employeeList = query.list();
            //Employee employeeList = query.uniqueResult();

            if (employeeList != null) {
                System.out.println(employeeList);
            } else {
                System.out.println("Employee Not Found");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void updateEmployee(String name) {
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            String HQL = "Update Employee set name=:empName where name=:currentName";

            Query<Employee> query = session.createQuery(HQL);
            query.setParameter("empName", "TestName");
            query.setParameter("currentName", name);

            query.executeUpdate();

            transaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteEmployee(String name) {
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            String HQL = "Delete From Employee where name=:currentName";

            Query<Employee> query = session.createQuery(HQL);

            query.setParameter("currentName", name);

            query.executeUpdate();

            transaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void performOperationWithAggregateMaxFunction() {

        try (Session session = sessionFactory.openSession()) {

            String HQL = "SELECT max(salary) from Employee";
            Query<Object[]> query = session.createQuery(HQL, Object[].class);
            List<Object[]> objectsList = query.getResultList();
            objectsList.forEach(i ->
                    System.out.println("Max Salary of the Employee : " + i[0]));

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public void performOperationWithAggregateMinFunction() {

        try (Session session = sessionFactory.openSession()) {

            String HQLQuery = "SELECT min(salary) from Employee";
            Query<Object[]> query = session.createQuery(HQLQuery, Object[].class);
            List<Object[]> objectsList = query.getResultList();
            objectsList.forEach(i ->
                    System.out.println("Min Salary of the Employee : " + i[0]));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void performOperationWithAggregateCountFunction() {

        try (Session session = sessionFactory.openSession()) {

            String HQLQuery = "SELECT count(e) from Employee e";
            Query<Object[]> query = session.createQuery(HQLQuery, Object[].class);
            List<Object[]> objectsList = query.getResultList();
            objectsList.forEach(i ->
                    System.out.println("Count Employee : " + i[0]));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void performOperationWithListOfAggregateFunctions() {

        try (Session session = sessionFactory.openSession()) {
            String HQLQuery = "SELECT count(e),min(e.salary),max(e.salary),sum(e.salary),AVG(e.salary) from Employee e";
            Query<Object[]> query = session.createQuery(HQLQuery, Object[].class);
            List<Object[]> objectsList = query.getResultList();
            objectsList.forEach(i -> {
                System.out.println("Count Employee : " + i[0]);
                System.out.println("Min Employee salary: " + i[1]);
                System.out.println("Max Employee Salary : " + i[2]);
                System.out.println("Sum of Employee Salary : " + i[3]);
                System.out.println("Avg of Employee Salary : " + i[4]);
            });
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getAllEmployeeIdAndNames() {

        try (Session session = sessionFactory.openSession()) {
            String HQL = "select e.id,e.name from Employee e";
            Query<Object[]> query = session.createQuery(HQL,Object[].class);
            List<Object[]> objects = query.list();
            objects.forEach(i->{
                System.out.println("ID : "+ i[0] + " Name : "+ i[1]);
            });


        } catch (Exception exception) {

        }
    }


}
