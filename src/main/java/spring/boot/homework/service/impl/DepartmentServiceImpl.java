package spring.boot.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.homework.entity.Department;
import spring.boot.homework.repository.DepartmentRepository;
import spring.boot.homework.service.interfaces.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartmentById(Long id) {
        Department department = departmentRepository.getByDepartmentId(id);
        departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        Department department = departmentRepository.getByDepartmentId(id);
        departmentRepository.delete(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.getByDepartmentId(id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }
}