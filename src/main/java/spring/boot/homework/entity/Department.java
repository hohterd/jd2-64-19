package spring.boot.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"employees"})
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String departmentName;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Set<Employee> employees = new HashSet<>(0);

    public Department(String name) {
        this.departmentName = name;
    }
}
