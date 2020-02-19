package by.it.academy.foodorder.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        TaskService taskService = (TaskService) context.getBean("taskService");
        taskService.performJob("Spring");
        taskService.performJob();
        taskService.performJobAround();
        try{
            taskService.performExceptionJob();
        }catch (Exception e){
            log.info("Error", e);
        }
        ((ClassPathXmlApplicationContext) context).close();
    }
}
