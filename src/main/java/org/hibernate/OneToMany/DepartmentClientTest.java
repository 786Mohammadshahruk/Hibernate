package org.hibernate.OneToMany;

import org.hibernate.sql.Update;

import java.util.Arrays;

public class DepartmentClientTest {
    public static void main(String[] args) {
        DepartmentDao departmentDao = new DepartmentDao();
        departmentDao.addDepartment(getDepartment());
        //departmentDao.getDepartment(1);
    }

    private static Department getDepartment() {
        Department department = new Department();
        department.setDepartmentName("IT");
        Employee employee1 = new Employee();

        employee1.setEmployeeName("Anuj Kumar");
        employee1.setDepartment(department);

        Employee employee2 = new Employee();
        employee2.setEmployeeName("Amit Kumar");
        employee2.setDepartment(department);

        Employee employee3 = new Employee();
        employee3.setEmployeeName("Rahul Kumar");
        employee3.setDepartment(department);



        department.setEmployees(Arrays.asList(employee1,employee2,employee3));
        return department;
    }

    //Update
    //delete
}
