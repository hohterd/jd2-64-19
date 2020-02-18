package by.it.academy.foodorder.criteriaDAO.impl;

import by.it.academy.foodorder.criteriaDAO.EmployeeDao;
import by.it.academy.foodorder.entity.DepartamentCriteria;
import by.it.academy.foodorder.entity.EmployeeCriteria;
import by.it.academy.foodorder.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final EmployeeDaoImpl INSTANCE = new EmployeeDaoImpl();

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

    public static EmployeeDaoImpl getINSTANCE(){
        return INSTANCE;
    }

    @Override
    public List<EmployeeCriteria> getAll() {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);
        query.select(root);

        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByName(String name) {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        query.select(root).where(builder.equal(root.get("name"), name));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getAllWithNameNotNull() {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        query.select(root).where(builder.isNotNull(root.get("name")));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryGreaterThan(Double salary) {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        query.select(root).where(builder.gt(root.get("salary"), salary));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryGreaterThanOrderDesc(Double salary) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        query.select(root).where(builder.gt(root.get("salary"), salary)).orderBy(builder.desc(root.get("salary")));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryLessOrEqual(Double salary) {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        query.select(root).where(builder.le(root.get("salary"), salary));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeBetween(Integer from, Integer to) {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        query.select(root).where(builder.between(root.get("age"), from, to));
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeAndName(String name, Integer age) {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        Predicate predicate = builder.and
                (builder.equal(root.get("name"), name),
                builder.equal(root.get("age"), age));
        query.select(root).where(predicate);
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeOrName(String name, Integer age) {
        CriteriaQuery<EmployeeCriteria> query = builder.createQuery(EmployeeCriteria.class);
        Root<EmployeeCriteria> root = query.from(EmployeeCriteria.class);

        Predicate predicate = builder.or
                (builder.equal(root.get("name"), name),
                        builder.equal(root.get("age"), age));
        query.select(root).where(predicate);
        List<EmployeeCriteria> employees = sessionFactory.openSession().createQuery(query).getResultList();
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        query.select(builder.count(query.from(EmployeeCriteria.class)));

        long count = sessionFactory.openSession().createQuery(query).getSingleResult();
        return count;
    }

    @Override
    public Double getAverageSalary() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        query.select(builder.avg(query.from(EmployeeCriteria.class).get("salary")));

        Double avgSalary = sessionFactory.openSession().createQuery(query).getSingleResult();
        return avgSalary;
    }

    @Override
    public Double getMaxSalary() {
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        query.select(builder.max(query.from(EmployeeCriteria.class).get("salary")));

        Double avgSalary = sessionFactory.openSession().createQuery(query).getSingleResult();
        return avgSalary;
    }

    @Override
    public Integer getMinAge() {
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        query.select(builder.min(query.from(EmployeeCriteria.class).get("age")));

        Integer minAge = sessionFactory.openSession().createQuery(query).getSingleResult();
        return minAge;
    }

    @Override
    public Double getAverageSalaryByDep(Long depId) {
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        Root<EmployeeCriteria> employee = query.from(EmployeeCriteria.class);

        Join<EmployeeCriteria, DepartamentCriteria> employeeJoin =
                employee.join("departament", JoinType.INNER);
        query.select(builder.avg(employee.get("salary"))).
                where(builder.equal(employeeJoin.get("departamentId"),depId));

        Double avgSalaryByDep = sessionFactory.openSession().createQuery(query).getSingleResult();
        return avgSalaryByDep;
    }
}
