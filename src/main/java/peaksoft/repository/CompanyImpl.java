package peaksoft.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.repositoryInterface.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyImpl implements CompanyRepository {

    @PersistenceContext
    private  EntityManager entityManager;

    @Override
    public Company save(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    public void removeById(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
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
    public void update(Long id,Company company) {
        Company company1 = entityManager.find(Company.class,id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedName(company.getLocatedName());
        entityManager.merge(company);
    }
}
