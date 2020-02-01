package by.it.academy.foodorder;

import by.it.academy.foodorder.criteriaDAO.impl.EmployeeDaoImpl;
import by.it.academy.foodorder.entity.DepartamentCriteria;
import by.it.academy.foodorder.entity.EmployeeCriteria;
import by.it.academy.foodorder.entity.UserExample;
import by.it.academy.foodorder.hierarchy.Departament;
import by.it.academy.foodorder.hierarchy.Employee;
import by.it.academy.foodorder.hierarchy.EmployeeDetail;
import by.it.academy.foodorder.hierarchy.Meeting;
import by.it.academy.foodorder.util.HibernateUtil;
import by.it.academy.foodorder.util.HibernateUtilEntityManager;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        EmployeeDaoImpl employeeDao = EmployeeDaoImpl.getINSTANCE();

        DepartamentCriteria departament = new DepartamentCriteria("Dev");
        DepartamentCriteria departament2 = new DepartamentCriteria("Marketing");
        DepartamentCriteria departament3 = new DepartamentCriteria("DBA");

        EmployeeCriteria employee = new EmployeeCriteria
                (null, "Sergey", 500.0, 23, departament);

        EmployeeCriteria employee2 = new EmployeeCriteria
                (null, "Sergey", 300.0, 25, departament2);

        EmployeeCriteria employee2_null = new EmployeeCriteria
                (null, null, 1700.0, 25, departament2);

        EmployeeCriteria employee3 = new EmployeeCriteria
                (null, "Nikolay", 700.0, 30, departament3);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(departament);
        session.save(departament2);
        session.save(departament3);
        session.save(employee);
        session.save(employee2);
        session.save(employee2_null);
        session.save(employee3);
        session.getTransaction().commit();
        session.close();

        System.err.println(employeeDao.getAll() + "\n" +
        employeeDao.getByName("Sergey") + "\n" +
        employeeDao.getAllWithNameNotNull()+ "\n" +
        employeeDao.getSalaryGreaterThan(600.0) + "\n" +
        employeeDao.getSalaryGreaterThanOrderDesc(400.0) + "\n" +
        employeeDao.getSalaryLessOrEqual(500.0) + "\n" +
        employeeDao.getByAgeAndName("Sergey", 23) + "\n" +
        employeeDao.getByAgeBetween(20, 25) + "\n" +
        employeeDao.getByAgeOrName("Nikolay", 25) + "\n" +
        employeeDao.getEmployeeCount() + "\n" +
        employeeDao.getAverageSalary() + "\n" +
        employeeDao.getMaxSalary() + "\n" +
        employeeDao.getMinAge() + "\n" +
        employeeDao.getAverageSalaryByDep(2L));

        HibernateUtil.shutdown();
    }
}
