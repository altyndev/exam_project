package peaksoft.repository;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.repositoryInterface.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company save(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Company getById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public List<Company> getAll() {
        return entityManager.createQuery(
                "select s from Company s", Company.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Long id, Company company) {
        Company company1 = getById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setAddressCompany(company.getAddressCompany());
        entityManager.merge(company1);
    }
}
