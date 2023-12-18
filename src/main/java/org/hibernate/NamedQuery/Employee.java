package org.hibernate.NamedQuery;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_table")

@NamedQueries(value = {
        @NamedQuery(name = "getEmployeeById", query = "From Employee where empId=:emp_id")
})

@NamedNativeQueries(value = {
        @NamedNativeQuery(name = "findEmployeeWithNativeQuery", query = "select * from employee_table", resultClass = Employee.class)
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String empName;
    private String email;
    private Double salary;
    private String designation;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id")
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", salary='" + salary + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
