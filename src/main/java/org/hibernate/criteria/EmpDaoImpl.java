package org.hibernate.criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class EmpDaoImpl {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void addEmployee(List<Employee> employee) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            employee.forEach(i -> session.persist(i));
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getEmployee() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
            criteriaQuery.select(employeeRoot);

            Query<Employee> employeeQuery = session.createQuery(criteriaQuery);
            List<Employee> employeeList = employeeQuery.list();

            employeeList.forEach(i -> {
                double salary = i.getSalary();
                double salary_10 = salary * 10 / 100;
                double finalSalary = salary + salary_10;

                i.setSalary(finalSalary);

                System.out.println(i);
            });


        } catch (Exception exception) {

        }
    }


    //Select * from employee where emp_id = 1;
    public void getEmployeeById(int id) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Employee.class);
            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
            criteriaQuery.select(employeeRoot);

            //criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("empId"), id));
            criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("empName"), "Aman"));

            Query<Employee> employeeQuery = session.createQuery(criteriaQuery);
            List<Employee> employeeList = employeeQuery.list();

            employeeList.forEach(System.out::println);


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    // select empName,email,salary from employee;
    public void getEmpNameEmailSalary() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Employee.class);

            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

            Path<Object> name = employeeRoot.get("empName");

            Path<Object> email = employeeRoot.get("email");
            Path<Object> salary = employeeRoot.get("salary");

            criteriaQuery = criteriaQuery.multiselect(name, email, salary);
            Query<Employee> employeeQuery = session.createQuery(criteriaQuery);
            List<Employee> list = employeeQuery.list();

            list.forEach(i -> {
                System.out.println("Emp Name : " + i.getEmpName());
                System.out.println("Emp email : " + i.getEmail());
                System.out.println("Emp salary : " + i.getSalary());
                System.out.println("Emp salary : " + i.getDesignation());
                System.out.println("--------------------------------------");
            });


        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    //Select count(employee) from employee;
    public void getTotalNumberOfEmployee() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

            criteriaQuery.select(criteriaBuilder.count(employeeRoot));

            Query<Long> longQuery = session.createQuery(criteriaQuery);
            Long result = longQuery.getSingleResult();
            System.out.println(result);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



    //select max(salary) from employee
    public void getMaxSalaryOfEmployee() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);

            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

            criteriaQuery.select(criteriaBuilder.max(employeeRoot.get("salary")));

            Query<Double> longQuery = session.createQuery(criteriaQuery);
            Double result = longQuery.getSingleResult();
            System.out.println(result);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getAvgSalaryOfEmployee() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);

            Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

            criteriaQuery.select(criteriaBuilder.avg(employeeRoot.get("salary")));

            Query<Double> longQuery = session.createQuery(criteriaQuery);
            Double result = longQuery.getSingleResult();
            System.out.println(result);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }




    //JPA

    //HTML  CSS  JAVA_SCRIPT  +  React   --->  Spring boot

}
