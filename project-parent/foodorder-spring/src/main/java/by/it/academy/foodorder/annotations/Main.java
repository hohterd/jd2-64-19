package by.it.academy.foodorder.annotations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(NoXmlConfig.class);
        context.refresh();
        context.start();

        UserService service = context.getBean(UserService.class);

        log.info("User service getName: {}", service.getUserName());

        context.close();
    }
}
