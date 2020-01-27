package by.it.academy.foodorder;

import by.it.academy.foodorder.entity.Address;
import by.it.academy.foodorder.entity.Person;
import by.it.academy.foodorder.util.HibernateUtil;
import org.hibernate.Session;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Person person = new Person(null, "serg","koro", 23, new Address("Kalvariyskaya", "Minsk", "222000"), null);

        session.save(person);
        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.err.println(session.get(Person.class, 1L));
        session.close();
        HibernateUtil.shutdown();
    }
}
