package by.it.academy.foodorder.annotations;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component("privateAddress")
public class PrivateAddress implements Address{

    @Value("Belarus")
    private String country;
    @Value("Kalvariyskaya")
    private String street;
    @Value("50")
    private Integer house;
    @Value("30")
    private Integer flat;
}
