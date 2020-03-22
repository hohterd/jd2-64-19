package spring.boot.homework.dao;

import org.springframework.stereotype.Repository;
import spring.boot.homework.entity.EmployeeDetail;

@Repository
public class EmployeeDetailDaoImpl extends BaseDao<EmployeeDetail> implements EmployeeDetailDao {

    protected EmployeeDetailDaoImpl() {
        super(EmployeeDetail.class);
    }
}
