package com.App.Documentation.SNPC.service;

import com.App.Documentation.SNPC.entity.Employee;
import com.App.Documentation.SNPC.exception.ResourceNotFoundException;
import com.App.Documentation.SNPC.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeImplementation implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else {
            throw new ResourceNotFoundException("Employee with id"+ id +"Is not into the database try again");
        }

    }

    @Override
    public Employee AddEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee existingEmployee=getEmployeeById(id);
        existingEmployee.setFirstName(existingEmployee.getFirstName());
        existingEmployee.setLastName(existingEmployee.getLastName());
        existingEmployee.setEmail(existingEmployee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }
}
