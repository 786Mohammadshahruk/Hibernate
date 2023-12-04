package org.hibernate.controller;

import org.hibernate.entity.Address;
import org.hibernate.entity.Employee;
import org.hibernate.entity.Student;
import org.hibernate.service.HibernateService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HibernateTestController {


    public static void main(String[] args) throws Exception {
        HibernateService hibernateService = new HibernateService();
        Employee employee = getEmployee();
        //Create
        //hibernateService.createEmployee(employee);

        //Fetch Operation
        //Employee resultEmployee = hibernateService.getEmployeeById(1);
        //System.out.println(resultEmployee);

        //Update Operation
        //hibernateService.updateEmployee(3, "Amit");
        /*Employee newEmployee = new Employee();
        newEmployee.setContactNumber("8764366337");
        newEmployee.setLastName("Mishra");
        hibernateService.updateEmployee(1, newEmployee);*/

        //Delete Operation
        //hibernateService.deleteByEmployeeId(1);


        //calling Load Method
        //hibernateService.getEmployeeByIdUsingLoad(2);


        // Save Student
        hibernateService.saveStudent(getStudent());

    }

    private static Student getStudent() {

        Address address = new Address();
        address.setCity("City");
        address.setPin("PIN");
        address.setTown("Town");
        address.setState("MP");

        Student student = new Student();
        student.setFirstName("Student1 FirstName");
        student.setLastName("Student1 LastName");
        student.setContactNumber("12344444");
        student.setEmail("@gmail.com");
        student.setAddress(address);
        return student;
    }

    private static Employee getEmployee() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/Users/mohammadshahruk/Desktop/testFile.png");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);

        Employee employee = new Employee();
        employee.setFirstName("Rakesh");
        employee.setContactNumber("9876543210");
        employee.setAddress("Mumbai");
        employee.setLastName("kumar");
        employee.setSalary(100000.00);

        //employee.setImage(data);

        employee.setEmail("rakesh.kumar@gmail.com");
        return employee;
    }
}
