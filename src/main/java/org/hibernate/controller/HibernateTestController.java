package org.hibernate.controller;

import org.hibernate.entity.Employee;
import org.hibernate.service.HibernateService;

public class HibernateTestController {


    public static void main(String[] args) throws Exception {
        HibernateService hibernateService = new HibernateService();
        Employee employee = getEmployee();
        //Create
        //hibernateService.createEmployee(employee);

        //Fetch Operation
        //Employee resultEmployee = hibernateService.getEmployeeById(2);
        //System.out.println(resultEmployee);

        //Update Operation
        //hibernateService.updateEmployee(3, "Amit");
        /*Employee newEmployee = new Employee();
        newEmployee.setContactNumber("8764366337");
        newEmployee.setLastName("Mishra");
        hibernateService.updateEmployee(1, newEmployee);*/

        //Delete Operation
        hibernateService.deleteByEmployeeId(1);


    }


    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Rakesh");
        employee.setContactNumber("9876543210");
        employee.setAddress("Mumbai");
        employee.setLastName("kumar");
        employee.setEmail("rakesh.kumar@gmail.com");
        return employee;
    }
}
