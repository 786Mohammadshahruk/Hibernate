package org.hibernate.HQL_JOIN;

public class HqlJoinTest {

    private static HqlJoinDao hqlJoinDao = new HqlJoinDao();

    public static void main(String[] args) {

        //hqlJoinDao.addEmployee(getEmployee());
        hqlJoinDao.getAddress(1);

    }

    private static Employee getEmployee() {

        Employee employee = new Employee();
        employee.setName("Aman Kumar");

        Address address = new Address();
        address.setCity("Mumbai");
        address.setEmployee(employee);

        employee.setAddress(address);
        return employee;

    }
}
