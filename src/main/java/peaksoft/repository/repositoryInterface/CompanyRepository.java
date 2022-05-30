package peaksoft.repository.repositoryInterface;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository {

    Company save(Company company);

     void removeById(Long id);

    Company getById(Long id);

    List<Company> getAll();

     void update(Long id,Company company);

    // Optional<Company> findById(Long id);

}
