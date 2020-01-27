package by.it.academy.foodorder.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEP_ID", unique = true)
    private Long departamentId;
    @Column(name = "DEP_NAME")
    private String departamentName;

    @OneToMany(mappedBy = "departament", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private Set<Employee> employees = new HashSet<>();

    public Departament(String name){
        this.departamentName = name;
    }

}
