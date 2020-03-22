package spring.boot.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boot.homework.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Employee getById(Long id);

}
