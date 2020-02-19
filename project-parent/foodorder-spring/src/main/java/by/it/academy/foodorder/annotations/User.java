package by.it.academy.foodorder.annotations;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@NoArgsConstructor
@Slf4j
public class User {
    private Long id;
    private String name;
    @Autowired
    @Qualifier("privateAddress")
    private Address address;

    public void init(){
      log.info("User init method");
    }

    public void destroy(){
        log.info("User destroy method");
    }
}
