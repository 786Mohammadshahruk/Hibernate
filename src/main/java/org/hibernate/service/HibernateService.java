package org.hibernate.service;

import org.hibernate.Session;
import org.hibernate.entity.Employee;
import org.hibernate.dao.HibernateDao;

public class HibernateService {

    HibernateDao hibernateDao = new HibernateDao();

    public void createEmployee(Employee employee) {
        hibernateDao.createEmployee(employee);
    }

    public Employee getEmployeeById(int employeeId) {
        return hibernateDao.getEmployeeById(employeeId);
    }
}
