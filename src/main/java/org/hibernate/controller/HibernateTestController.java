package org.hibernate.controller;

import org.hibernate.entity.Employee;
import org.hibernate.service.HibernateService;

public class HibernateTestController {


    public static void main(String[] args) {
        HibernateService hibernateService = new HibernateService();
        Employee employee = getEmployee();
        //hibernateService.createEmployee(employee);

        //Fetch Operation
        Employee resultEmployee = hibernateService.getEmployeeById(2);
        System.out.println(resultEmployee);
    }


    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Rakesh");
        employee.setAddress("Mumbai");
        employee.setLastName("kumar");
        employee.setEmail("rakesh.kumar@gmail.com");
        return employee;
    }
}
