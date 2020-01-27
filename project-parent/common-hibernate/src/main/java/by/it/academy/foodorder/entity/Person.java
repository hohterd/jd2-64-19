package by.it.academy.foodorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Person_Table")
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "User_name", nullable = false)
    private String name;
    @Column(name = "User_surname", nullable = false)
    private String surname;
    @Column(length = 3)
    private Integer age;
    @Embedded
    private Address address;

    @Formula(value = "CONCAT(User_name, ' ' , User_surname)")
    private String fullName;
}
