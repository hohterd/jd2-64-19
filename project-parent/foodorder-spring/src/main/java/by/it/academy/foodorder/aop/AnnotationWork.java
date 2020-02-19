package by.it.academy.foodorder.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
@Slf4j
public class AnnotationWork {

    @Pointcut("execution(* by.it.academy.foodorder.aop.TaskService.performJob())")
    public void performance(){

    }

    @Pointcut("execution(* by.it.academy.foodorder.aop.TaskService.performJob(String)) && args(name)")
    public void intercept(String name){

    }

    @Before("performance()")
    public void beforeWork(){
        log.info("Execution before work");
    }

    @AfterReturning("performance()")
    public void afterWork(){
        log.info("Execution after work");
    }

    @AfterReturning("performance()")
    public void afterWorkProblems(){
        log.info("Execution after work problems");
    }

    @Around("performance()")
    public void aroundWork(ProceedingJoinPoint point){
        try {
            log.info("Start");
            log.info("Begin time: " + System.currentTimeMillis());
            String result = (String) point.proceed();
            log.info("Finish time: " + System.currentTimeMillis());
            log.info("Status: " + result);
        }catch (Throwable throwable){
            log.error(String.valueOf(throwable));
        }
    }

    @Before("intercept(name)")
    public void interceptWorkName(String name){
        log.info("Intercepted work is "+ name);
    }
}
