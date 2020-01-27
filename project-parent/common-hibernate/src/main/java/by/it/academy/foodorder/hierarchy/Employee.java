package by.it.academy.foodorder.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", unique = true)
    private Long employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private LocalDateTime date;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    @Access(AccessType.PROPERTY)
    private EmployeeDetail employeeDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEP_ID")
    private Departament departament;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "EMPLOYEE_MEETING",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MEETING_ID")})
    private List<Meeting> meetings = new ArrayList<>();

}
