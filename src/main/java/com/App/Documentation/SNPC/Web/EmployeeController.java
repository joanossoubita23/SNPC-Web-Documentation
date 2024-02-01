package com.App.Documentation.SNPC.Web;

import com.App.Documentation.SNPC.entity.Employee;
import com.App.Documentation.SNPC.repository.EmployeeRepository;
import com.App.Documentation.SNPC.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService) {
        this.employeeService = employeeService;

    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployee(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return  new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> AddEmployee(@RequestBody Employee employee){
        return  new ResponseEntity<>(employeeService.AddEmployee(employee),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long id){
        employeeService.getEmployeeById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id,@RequestBody Employee employee){
        return  new ResponseEntity<>(employeeService.updateEmployeeById(id,employee),HttpStatus.CREATED);
    }
}
