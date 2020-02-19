package by.it.academy.foodorder.annotations;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component("companyAddress")
public class CompanyAddress {

    @Value("company address")
    private String companyAddress;
}
