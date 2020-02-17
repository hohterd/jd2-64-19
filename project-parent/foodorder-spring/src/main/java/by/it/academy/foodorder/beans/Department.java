package by.it.academy.foodorder.beans;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class Department {

    private Long id;

    private String name;

    @ToString.Exclude
    private List<Person> employees;

}
