package by.it.academy.foodorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class UserExample {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String role;
    @Column
    private Integer age;
}
