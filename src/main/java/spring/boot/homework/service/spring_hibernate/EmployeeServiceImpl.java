package spring.boot.homework.service.spring_hibernate;

import org.springframework.stereotype.Service;
import spring.boot.homework.dao.DAO;
import spring.boot.homework.entity.Employee;

@Service
public class EmployeeServiceImpl extends BaseService<Employee> implements EmployeeService{

    public EmployeeServiceImpl(DAO<Employee> baseDao) {
        super(baseDao);
    }

}
