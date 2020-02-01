package by.it.academy.foodorder.entity;

import by.it.academy.foodorder.hierarchy.Departament;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class EmployeeCriteria {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private Double salary;
    @Column
    private Integer age;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEP_ID")
    private DepartamentCriteria departament;
}
