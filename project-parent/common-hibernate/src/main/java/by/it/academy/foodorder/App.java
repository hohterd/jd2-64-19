package by.it.academy.foodorder;

import by.it.academy.foodorder.criteriaDAO.impl.EmployeeDaoImpl;
import by.it.academy.foodorder.criteriaDAO.impl.HqlEmployeeDaoImpl;
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
import org.hibernate.SessionFactory;

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

        HqlEmployeeDaoImpl hqlEmployeeDao = HqlEmployeeDaoImpl.getINSTANCE();

        DepartamentCriteria departament = new DepartamentCriteria("Dev");
        DepartamentCriteria departament2 = new DepartamentCriteria("Marketing");
        EmployeeCriteria employee = new EmployeeCriteria(null,"Sergey", 500.0, 23, departament);
        EmployeeCriteria employee2 = new EmployeeCriteria(null,"Nikolay", 400.0, 24, departament);
        EmployeeCriteria employee3 = new EmployeeCriteria(null,null, 1200.0, 26, departament2);

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(departament);
        session.save(departament2);
        session.save(employee);
        session.save(employee2);
        session.save(employee3);
        session.getTransaction().commit();
        session.close();

        System.err.println(hqlEmployeeDao.getAverageSalaryByDep(1L));

        HibernateUtil.shutdown();
    }
}
