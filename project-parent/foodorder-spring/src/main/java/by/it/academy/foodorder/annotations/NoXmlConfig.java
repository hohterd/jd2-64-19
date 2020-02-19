package by.it.academy.foodorder.annotations;

import by.it.academy.foodorder.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "by.it.academy.foodorder.annotations")
public class NoXmlConfig {

    @Bean(name = "user", initMethod = "init", destroyMethod = "destroy")
    public User getUser(){
        User user = new User();
        user.setId(1L);
        user.setName("Name from NoXmlConfig");
        return user;
    }
}
