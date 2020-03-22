package spring.boot.homework.service.interfaces;

import org.springframework.stereotype.Service;
import spring.boot.homework.entity.Department;
import spring.boot.homework.entity.Employee;

import java.util.List;

@Service
public interface EmployeeService {

    void save(Employee employee);

    void createEmployee(Employee employee);

    void updateEmployeeById(Long id);

    Employee updateEmployee(Employee employee);

    List<Employee> getAllByDepId(Long id);

    void deleteEmployeeById(Long id);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();
}
