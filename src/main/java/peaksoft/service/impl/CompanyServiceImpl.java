package peaksoft.service.impl;

import org.springframework.stereotype.Service;
import peaksoft.model.Company;
import peaksoft.repository.repositoryInterface.CompanyRepository;
import peaksoft.service.CompanyService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) {
        companyRepository.save(company);
        return company;
    }

    @Override
    public void removeById(Long id) {
        Company company = companyRepository.findById(id);
        companyRepository.removeByCompany(company);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id,Company company) {
        companyRepository.update(id,company);
    }
}
