package by.it.academy.foodorder.entity;

import by.it.academy.foodorder.hierarchy.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DepartamentCriteria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEP_ID", unique = true)
    private Long departamentId;
    @Column(name = "DEP_NAME")
    private String departamentName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "departament", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<EmployeeCriteria> employees = new ArrayList<>();

    public DepartamentCriteria(String name) {
        this.departamentName = name;
    }


}
