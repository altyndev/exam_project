package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {
    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "group_sequence")
    private Long id;

    private String name;

    @Column(name = "date_of_start")
    private String dateOfStart;

    @Column(name = "date_of_finish")
    private String dateOfFinish;

    @Transient
    private Long courseId;

    @ManyToMany(cascade = {PERSIST, MERGE, DETACH, REFRESH},fetch = LAZY, mappedBy = "groups")
    private List<Course>courses;

    @OneToMany(cascade = {MERGE, REFRESH, DETACH, REMOVE}, orphanRemoval = true, fetch = EAGER, mappedBy = "group")
    private List<Student> students;

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    public void setCourse1(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroups1(this);
    }
}
