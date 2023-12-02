package org.hibernate.service;

import org.hibernate.Session;
import org.hibernate.entity.Employee;
import org.hibernate.dao.HibernateDao;

public class HibernateService {

    HibernateDao hibernateDao = new HibernateDao();

    public void createEmployee(Employee employee) throws Exception {
        String email = employee.getEmail();
        if (employee.getContactNumber().length() > 10) {
            throw new Exception("ContactNumber is Not Correct");
        }
        if (!email.contains("@gmail.com")) {
            throw new Exception("Email is Not Correct");
        }
        hibernateDao.createEmployee(employee);
    }

    public Employee getEmployeeById(int employeeId) {
        return hibernateDao.getEmployeeById(employeeId);
    }

    public void updateEmployee(int employeeId, String firstName) {
        hibernateDao.updateEmployee(employeeId, firstName);
    }

    public void updateEmployee(int employeeId, Employee newEmployee) {
        hibernateDao.updateEmployee(employeeId, newEmployee);
    }

    public void deleteByEmployeeId(int employeeId) {
        hibernateDao.deleteByEmployeeId(employeeId);
    }

}
