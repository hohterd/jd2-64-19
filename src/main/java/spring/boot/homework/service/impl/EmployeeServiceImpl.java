package spring.boot.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.homework.entity.Employee;
import spring.boot.homework.repository.EmployeeRepository;
import spring.boot.homework.service.interfaces.EmployeeService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void save(Employee employee) {
        employee.setDate(LocalDateTime.now());
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void updateEmployeeById(Long id) {
        Employee employee = employeeRepository.getById(id);
        employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional

    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.getById(id);
        employeeRepository.delete(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }
}