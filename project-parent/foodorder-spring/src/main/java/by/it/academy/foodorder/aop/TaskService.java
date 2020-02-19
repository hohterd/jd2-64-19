package by.it.academy.foodorder.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("taskService")
public class TaskService {

    public void performJob(){
        log.info("Perform Job");
    }

    public void performExceptionJob() throws Exception{
        log.info("Throws exception in Job");
        throw new Exception("Exception Job");
    }

    public String performJobAround(){
        log.info("Perform around Job");
        return "Success";
    }

    public void performJob(String name){
        log.info("Job name: " + name);
    }
}
