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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "address_company")
    private String addressCompany;

    @OneToMany(cascade = ALL, fetch = EAGER, mappedBy = "company")
    private List<Course> courses;

    public Company(String companyName, String addressCompany) {
        this.companyName = companyName;
        this.addressCompany = addressCompany;
    }
}
