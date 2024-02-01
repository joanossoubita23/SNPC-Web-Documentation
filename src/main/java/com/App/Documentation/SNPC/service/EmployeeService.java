package com.App.Documentation.SNPC.service;

import com.App.Documentation.SNPC.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployee();
    Employee getEmployeeById(Long id);
    Employee AddEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    Employee updateEmployeeById(Long id, Employee employee);

}
