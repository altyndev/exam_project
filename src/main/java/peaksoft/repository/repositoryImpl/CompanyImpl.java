package peaksoft.repository.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.repository.repositoryInterface.CompanyRepository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CompanyImpl implements CompanyRepository<Company> {


    @Override
    public <T> T saveCompany(T t) {
        return null;
    }

    @Override
    public <T> void removeCompanyById(Long id) {

    }

    @Override
    public <T> T getById(Long id) {
        return null;
    }

    @Override
    public List<?> getAllCompany() {
        return null;
    }

    @Override
    public <T> void update(Long id, T t) {

    }
}
