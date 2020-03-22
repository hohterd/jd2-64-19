package spring.boot.homework.service.interfaces;

import org.springframework.stereotype.Service;
import spring.boot.homework.entity.Department;

import java.util.List;

@Service
public interface DepartmentService {

    void save(Department department);

    void createDepartment(Department department);

    void updateDepartmentById(Long id);

    Department updateDepartment(Department department);

    void deleteDepartmentById(Long id);

    Department getDepartmentById(Long id);

    List<Department> getAllDepartments();

}
