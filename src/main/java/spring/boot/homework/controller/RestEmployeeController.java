package spring.boot.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.homework.entity.Employee;
import spring.boot.homework.service.interfaces.EmployeeService;

import java.util.List;

@RestController
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> readEmployee(
            @PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);

        return employee != null ? new ResponseEntity<>(employee, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> read(){
        List<Employee> employees = employeeService.getAllEmployees();

        return employees != null && !employees.isEmpty() ? new ResponseEntity<>(employees, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/employees")
    public ResponseEntity<?> update(@RequestBody Employee employee ){
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(employeeService.getEmployeeById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}