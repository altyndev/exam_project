package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_sequence")
    private Long id;

    private String name;

    @Column(name = "duration")
    private String duration;

    @ManyToOne
    private Company company;

    @ManyToMany(cascade = {PERSIST, MERGE, DETACH, REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "groups_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    @OneToOne(cascade = ALL, fetch = EAGER, mappedBy = "course")
    private Teacher teacher;

    public Course(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public void setGroups1(Group group) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);
    }
}