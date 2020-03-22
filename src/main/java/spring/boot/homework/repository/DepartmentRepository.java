package spring.boot.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boot.homework.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Department getByDepartmentId(Long id);

}
