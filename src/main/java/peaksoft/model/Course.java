package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "duration")
    private String duration;

    @ManyToOne(cascade = {PERSIST,MERGE,DETACH,REFRESH},fetch = LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = {MERGE, PERSIST, REFRESH}, fetch = EAGER, mappedBy = "courses")
    private List<Group> groups;

    @OneToOne(cascade = ALL, fetch = EAGER, mappedBy = "course")
    private Teacher teacher;

    public void getAllGroup(Group group) {
        if (group == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);
    }
}