package peaksoft.repository.repositoryInterface;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyRepository <T> {

    <T> T saveCompany(T t);

    <T>  void removeCompanyById(Long id);

    <T> T getById(Long id);

    List<?> getAllCompany();

    <T> void update(Long id, T t);

}
