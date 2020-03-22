package spring.boot.homework.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmployeeDetail {

    @Id
    @GenericGenerator(name = "one-one",strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
    @GeneratedValue(generator = "one-one")
    private Long id;

    private String city;

    private String street;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Employee employee;

}
