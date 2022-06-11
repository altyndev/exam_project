package peaksoft.repository;

import org.springframework.stereotype.Repository;
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
    public void removeByCompany(Company company) {
        entityManager.remove(company);
    }

    @Override
    public Company findById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public List<Company> findAll() {
        return entityManager.createQuery(
                "select s from Company s", Company.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Long id, Company company) {
        Company company1 = findById(id);
        company1.setName(company.getName());
        company1.setAddress(company.getAddress());
        entityManager.merge(company1);
    }
}
