package org.hibernate.criteria;

import java.util.List;

public class ClientTest {

    private static EmpDaoImpl empDao = new EmpDaoImpl();

    public static void main(String[] args) {
        //empDao.addEmployee(employees());
        //empDao.getEmployee();
        //empDao.getEmployeeById(1);
        //empDao.getEmpNameEmailSalary();
        //empDao.getTotalNumberOfEmployee();
        //empDao.getMaxSalaryOfEmployee();
        empDao.getAvgSalaryOfEmployee();
    }

    private static List<Employee> employees() {
        Employee employee = new Employee();
        employee.setDesignation("Software Eng.");
        employee.setEmail("test@gmail.com");
        employee.setSalary(2000000.00);
        employee.setEmpName("Aman");


        Employee employee2 = new Employee();
        employee2.setDesignation("Mechanical Eng.");
        employee2.setEmail("test@gmail.com");
        employee2.setSalary(20000.00);
        employee2.setEmpName("Ajay");

        Employee employee3 = new Employee();
        employee3.setDesignation("Civil Eng.");
        employee3.setEmail("test@gmail.com");
        employee3.setSalary(2000.00);
        employee3.setEmpName("Rakesh");

        return List.of(employee, employee2, employee3);
    }
}
