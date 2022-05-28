package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "duration")
    private String duration;

    @ManyToOne(cascade = {PERSIST, MERGE})
    private Company company;

    @ManyToMany(cascade = {MERGE, PERSIST, REFRESH}, fetch = EAGER, mappedBy = "courseList")
    private List<Group> group;

    @OneToOne(cascade = ALL, fetch = EAGER)
    private Teacher teacher;
}