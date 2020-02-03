package by.it.academy.foodorder.criteriaDAO.impl;

import by.it.academy.foodorder.criteriaDAO.EmployeeDao;
import by.it.academy.foodorder.entity.DepartamentCriteria;
import by.it.academy.foodorder.entity.EmployeeCriteria;
import by.it.academy.foodorder.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HqlEmployeeDaoImpl implements EmployeeDao {

    private static final HqlEmployeeDaoImpl INSTANCE = new HqlEmployeeDaoImpl();

    public static HqlEmployeeDaoImpl getINSTANCE(){
        return INSTANCE;
    }


    @Override
    public List<EmployeeCriteria> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("FROM EmployeeCriteria", EmployeeCriteria.class);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.name =: name ", EmployeeCriteria.class);
        query.setParameter("name", name);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getAllWithNameNotNull() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.name is not null", EmployeeCriteria.class);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryGreaterThan(Double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.salary >=: salary", EmployeeCriteria.class);
        query.setParameter("salary", salary);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryGreaterThanOrderDesc(Double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.salary >=: salary order by empl.salary desc", EmployeeCriteria.class);
        query.setParameter("salary", salary);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getSalaryLessOrEqual(Double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.salary <=: salary order by empl.salary desc", EmployeeCriteria.class);
        query.setParameter("salary", salary);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeBetween(Integer from, Integer to) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.age between :begin and :end", EmployeeCriteria.class);
        query.setParameter("begin", from);
        query.setParameter("end", to);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeAndName(String name, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.age =: age and empl.name =: name", EmployeeCriteria.class);
        query.setParameter("age", age);
        query.setParameter("name", name);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public List<EmployeeCriteria> getByAgeOrName(String name, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<EmployeeCriteria> query = session.createQuery("select empl from EmployeeCriteria empl where empl.age =: age or empl.name =: name", EmployeeCriteria.class);
        query.setParameter("age", age);
        query.setParameter("name", name);
        List<EmployeeCriteria> employees = query.list();
        return employees;
    }

    @Override
    public long getEmployeeCount() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<Long> query = session.createQuery("select count(empl) from EmployeeCriteria empl", Long.class);
        Long count = query.getSingleResult();
        return count;
    }

    @Override
    public Double getAverageSalary() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<Double> query = session.createQuery("select avg(empl.salary) from EmployeeCriteria empl", Double.class);
        Double averageSalary = query.getSingleResult();
        return averageSalary;
    }

    @Override
    public Double getMaxSalary() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<Double> query = session.createQuery("select max(empl.salary) from EmployeeCriteria empl", Double.class);
        Double maxSalary = query.getSingleResult();
        return maxSalary;
    }

    @Override
    public Integer getMinAge() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<Integer> query = session.createQuery("select min(empl.age) from EmployeeCriteria empl", Integer.class);
        Integer minAge = query.getSingleResult();
        return minAge;
    }

    @Override
    public Double getAverageSalaryByDep(Long depId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query<Double> query = session.createQuery("select distinct avg(empl.salary) from EmployeeCriteria empl where empl.departament.departamentId =: depId", Double.class);
        query.setParameter("depId", depId);
        Double avgSalaryByDep = query.getSingleResult();
        return avgSalaryByDep;
    }
}
