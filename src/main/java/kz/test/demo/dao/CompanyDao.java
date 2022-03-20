package kz.test.demo.dao;

import kz.test.demo.model.entity.Company;

import java.util.List;

public interface CompanyDao {

    List<Company> selectAllCompany();
    Company selectCompanyById(long id);

    void renameCompanyById(long id,String name);
    void insertNewCompany(Company company);
    void deleteCompanyById(long id);


}
