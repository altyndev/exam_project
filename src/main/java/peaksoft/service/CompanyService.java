package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Company;

import java.util.List;

@Service
public interface CompanyService {

    Company save(Company company);

    void removeById(Long id);

    Company findById(Long id);

    List<Company> findAll();

    void update(Long id, Company company);

}
