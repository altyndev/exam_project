package peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "companies")
@Getter@Setter
@NoArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "company_sequence")
    private Long id;

    private String name;

    private String address;

    @OneToMany(cascade = {REMOVE, MERGE},  mappedBy = "company")
    private List<Course> courses;

    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
