package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;

import java.util.List;

@Repository
public interface CompanyRepository {

    Company save(Company company);

     void removeByCompany(Company company);

    Company findById(Long id);

    List<Company> findAll();

     void update(Long id,Company company);
}
