package org.hibernate.HQL;

import java.util.Arrays;
import java.util.List;

public class EmployeeClientTest {

    static EmployeeDao employeeDao = new EmployeeDao();

    public static void main(String[] args) {
        //CreateEmployee
        //employeeDao.addEmployee(getEmployeeList());


        //fetch All Employee
        //List<Employee> employeeList = employeeDao.getAllEmployee();
        //employeeList.forEach(System.out::println);
        //employeeList.forEach(i-> System.out.println(i));

        //fetch Employee
        //employeeDao.getEmployee("Aman");

        //employeeDao.getEmployeeBySalaryAndName(800000,"Ajay");

        //employeeDao.updateEmployee("Ajay");
        //employeeDao.deleteEmployee("Aman");

        //employeeDao.performOperationWithAggregateMaxFunction();
        //employeeDao.performOperationWithAggregateMinFunction();
        //employeeDao.performOperationWithAggregateCountFunction();
        //employeeDao.performOperationWithListOfAggregateFunctions();
        employeeDao.getAllEmployeeIdAndNames();


    }

    private static List<Employee> getEmployeeList() {
        Employee employee1 = new Employee();
        employee1.setName("Test_2");
        employee1.setSalary(1500000);
        Employee employee2 = new Employee();
        employee2.setName("Test_3");
        employee2.setSalary(2000000);
        Employee employee3 = new Employee();
        employee3.setName("Test_4");
        employee3.setSalary(700000);
        return Arrays.asList(employee1, employee2, employee3);
    }
}
