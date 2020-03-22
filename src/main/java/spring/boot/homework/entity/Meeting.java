package spring.boot.homework.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Employee_Meeting",
            joinColumns = @JoinColumn(name = "Meeting_id"),
            inverseJoinColumns = @JoinColumn(name = "Employee_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Employee> employees;

    public Meeting(String subject) {
        this.subject = subject;
    }



}