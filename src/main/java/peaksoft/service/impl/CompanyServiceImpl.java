package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.repositoryInterface.CompanyRepository;
import peaksoft.service.CompanyService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        companyRepository.save(company);
        return company;
    }

    @Override
    public void removeById(Long id) {
     companyRepository.removeById(id);
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    @Override
    public void update(Long id,Company company) {
        companyRepository.update(id,company);
    }
}
