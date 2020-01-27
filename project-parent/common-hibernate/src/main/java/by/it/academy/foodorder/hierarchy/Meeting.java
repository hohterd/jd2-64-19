package by.it.academy.foodorder.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MEETING")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID", unique = true)
    private Long meetingId;
    private String nameMeeting;
    private LocalDateTime dateTime;

    @ManyToMany(mappedBy = "meetings")
    private List<Employee> employees = new ArrayList<>();

    public Meeting(String name){
        this.nameMeeting = name;
        this.dateTime = LocalDateTime.now();
    }
}
