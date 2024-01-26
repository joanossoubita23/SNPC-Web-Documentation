package com.App.Documentation.SNPC.service;

import com.App.Documentation.SNPC.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getemployee();
    Employee getEmployeeById(Long id);
    Employee AddEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    Employee addEmployee(Long id, Employee employee);

}
