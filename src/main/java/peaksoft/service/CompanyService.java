package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Company;

import javax.transaction.Transactional;
import java.util.List;


public interface CompanyService {

    Company save(Company company);

    void removeById(Long id);

    Company getById(Long id);

    List<Company> getAll();

    void update(Long id, Company t);

}
