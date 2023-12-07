package org.hibernate.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DepartmentDao {

    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();

    }

    public void addDepartment(Department department) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(department);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDepartment(int department_id) {
        try (Session session = sessionFactory.openSession()) {
            Department department = session.get(Department.class, department_id);
            if (department != null && department.getEmployees() != null) {
                System.out.println("Department : " + department);
                List<Employee> employeeList = department.getEmployees();
                System.out.println("Employee List : " + employeeList);
            } else {
                System.out.println("Department Not Present ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
