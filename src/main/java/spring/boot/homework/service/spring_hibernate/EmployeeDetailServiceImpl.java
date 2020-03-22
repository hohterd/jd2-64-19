package spring.boot.homework.service.spring_hibernate;

import org.springframework.stereotype.Service;
import spring.boot.homework.dao.DAO;
import spring.boot.homework.entity.EmployeeDetail;

@Service
public class EmployeeDetailServiceImpl extends BaseService<EmployeeDetail> implements EmployeeDetailService {

    public EmployeeDetailServiceImpl(DAO<EmployeeDetail> baseDao) {
        super(baseDao);
    }
}
