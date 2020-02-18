package by.it.academy.foodorder;


import by.it.academy.foodorder.beans.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = context.getBean("person", Person.class);
        System.err.println(person.toString());
        ((ConfigurableApplicationContext) context).close();

    }
}
