package org.hibernate.OneToMany;

import org.hibernate.sql.Update;

import java.util.Arrays;

public class DepartmentClientTest {
    public static void main(String[] args) {
        DepartmentDao departmentDao = new DepartmentDao();
        //departmentDao.addDepartment(getDepartment());
        departmentDao.getDepartment(1);
    }

    private static Department getDepartment() {

        Employee employee1 = new Employee();
        employee1.setEmployeeName("Anuj Kumar");

        Employee employee2 = new Employee();
        employee2.setEmployeeName("Amit Kumar");

        Employee employee3 = new Employee();
        employee3.setEmployeeName("Rahul Kumar");

        Department department = new Department();
        department.setDepartmentName("IT");

        department.setEmployees(Arrays.asList(employee1,employee2,employee3));
        return department;
    }

    //Update
    //delete
}
