package by.it.academy.foodorder.beans;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class Meeting {

    private Long id;

    @ToString.Exclude
    private List<Person> personList;
}
