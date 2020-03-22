package spring.boot.homework.service.spring_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.homework.entity.Department;
import spring.boot.homework.repository.DepartmentRepository;

import java.io.Serializable;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department get(Serializable id) {
        Optional<Department> department = departmentRepository.findById(Long.valueOf(id.toString()));
        return department.orElse(null);
    }

    @Override
    public void remove(Serializable id) {
            departmentRepository.deleteById(Long.valueOf(id.toString()));
    }
}
