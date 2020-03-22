package spring.boot.homework.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.homework.entity.Department;
import spring.boot.homework.entity.Employee;
import spring.boot.homework.service.interfaces.DepartmentService;
import spring.boot.homework.service.interfaces.EmployeeService;

import java.util.List;

@RestController
public class RestDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/departments/{id}")
    public ResponseEntity<Department> readDepById(
            @PathVariable("id") Long id){
        Department department = departmentService.getDepartmentById(id);

        return department != null ? new ResponseEntity<>(department, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/departments")
    public ResponseEntity<List<Department>> read(){
        List<Department> departments = departmentService.getAllDepartments();

        return departments != null && !departments.isEmpty() ? new ResponseEntity<>(departments, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/department/{id}")
    public ResponseEntity<List<Employee>> getAllByDep(@PathVariable("id") Long id){
        List<Employee> employees = employeeService.getAllByDepId(id);
        return employees != null && !employees.isEmpty() ? new ResponseEntity<>(employees, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/departments")
    public ResponseEntity<?> create(@RequestBody Department department){
        departmentService.createDepartment(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/departments")
    public ResponseEntity<?> update(@RequestBody Department department ){
        return new ResponseEntity<>(departmentService.updateDepartment(department), HttpStatus.OK);
    }

    @DeleteMapping(value = "/departments/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(departmentService.getDepartmentById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
