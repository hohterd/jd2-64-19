package spring.boot.homework.dao;

import org.springframework.stereotype.Repository;
import spring.boot.homework.entity.Employee;

@Repository
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {

    protected EmployeeDaoImpl() {
        super(Employee.class);
    }

}
