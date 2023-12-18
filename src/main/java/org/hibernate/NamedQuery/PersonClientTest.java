package org.hibernate.NamedQuery;

public class PersonClientTest {

    private static PersonDaoImpl personDao = new PersonDaoImpl();
    private static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    public static void main(String[] args) {
        //personDao.addPerson(getPerson());

        //personDao.getPerson();
        //personDao.getPersonNameAndDOB();


        //employeeDao.addEmployee(getEmployee());
        //employeeDao.getEmployee();
        employeeDao.getEmployeeByNative();


    }

    private static Employee getEmployee() {
        Department department = new Department();
        department.setDepLocation("Kolkata");
        department.setDepName("Test Department");

        Employee employee = new Employee();
        employee.setEmpName("Test name");
        employee.setDesignation("SE");
        employee.setEmail("1234test@gmail.com");
        employee.setSalary(120000.00);
        employee.setDepartment(department);

        department.setEmployee(employee);
        return employee;
    }

    private static Person getPerson() {
        Person person = new Person();
        person.setName("Test 1");
        person.setAddress("Dummy Address");
        person.setDob("01-01-2000");
        return person;
    }
}
