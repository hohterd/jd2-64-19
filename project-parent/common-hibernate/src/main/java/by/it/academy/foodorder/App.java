package by.it.academy.foodorder;

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
        UserExample user = new UserExample(null, "Sergey", "admin", 23);
        EntityManager entityManager = HibernateUtilEntityManager.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();
        UserExample userFromDB = entityManager.find(UserExample.class, user.getId());
        System.err.println(userFromDB);
    }
}
