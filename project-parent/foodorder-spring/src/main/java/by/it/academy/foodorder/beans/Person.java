package by.it.academy.foodorder.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Person {

    private Long id;
    private String name;
    private String surname;

    private PersonInfo personInfo;

    private Department department;

    private List<Meeting> meetings;
}
