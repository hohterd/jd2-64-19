package spring.boot.homework.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;
    @CreationTimestamp
    private LocalDateTime date;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private EmployeeDetail employeeDetail;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Department department;

    @ManyToMany(mappedBy = "employees", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Meeting> meetings;
}