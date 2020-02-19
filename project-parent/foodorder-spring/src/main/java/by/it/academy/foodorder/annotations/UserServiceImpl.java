package by.it.academy.foodorder.annotations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final User user;

    @Autowired
    public UserServiceImpl(User user){
        this.user = user;
    }

    @Override
    public String getUserName() {
        return user.getName();
    }

    @PostConstruct
    public void init(){
        log.info("User Service Post Construct");
    }

    @PreDestroy
    public void destroy(){
        log.info("User Service Pre Destroy");
    }
}
