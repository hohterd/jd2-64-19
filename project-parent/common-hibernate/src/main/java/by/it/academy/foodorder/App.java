package by.it.academy.foodorder;

import by.it.academy.foodorder.hierarchy.Departament;
import by.it.academy.foodorder.hierarchy.Employee;
import by.it.academy.foodorder.hierarchy.EmployeeDetail;
import by.it.academy.foodorder.hierarchy.Meeting;
import by.it.academy.foodorder.util.HibernateUtil;
import org.hibernate.Session;

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        /*//OneToOne
        session.beginTransaction();
        employee = new Employee(null, "Sergey",
                "Korolyov", LocalDateTime.now(), null, null);
        EmployeeDetail detail = new EmployeeDetail(null, "Street", "City",
                "State", "Country", null);
        employee.setEmployeeDetail(detail);
        detail.setEmployee(employee);
        session.save(detail);
        session.getTransaction().commit();
        session.close();*/

        /*//OneToMany
        session.beginTransaction();
        Departament departament = new Departament("Dev");
        employee = new Employee(null, "Sergey",
                "Korolyov", LocalDateTime.now(), null, departament);
        session.save(departament);
        session.save(employee);
        session.getTransaction().commit();
        session.close();*/


        //ManyToMany
        session.beginTransaction();
        Employee employee = new Employee(null, "Sergey", "Korolyov",
                LocalDateTime.now(), null, null, new HashSet<>());
        Meeting meeting = new Meeting("ManyToMany");
        meeting.getEmployees().add(employee);
        session.save(meeting);
        employee.getMeetings().add(meeting);
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }
}
