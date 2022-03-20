package kz.test.demo.model.service.impl;

import kz.test.demo.dao.CompanyDao;
import kz.test.demo.model.entity.Company;
import kz.test.demo.model.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public ResponseEntity<List<Company>> readAllCompany()
    {

        return ResponseEntity.ok(companyDao.selectAllCompany());
    }


    @Override
    public ResponseEntity<String> createNewCompany(Company company) {

        if(company.getName() == null)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        companyDao.insertNewCompany(company);
        return ResponseEntity.ok("");
    }


    @Override
    public ResponseEntity<String> deleteCompanyById(long id) {
        final Company company = companyDao.selectCompanyById(id);

        if(company == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        companyDao.deleteCompanyById(id);

        return ResponseEntity.ok("");

    }

    @Override
    public ResponseEntity<String> updateCompanyById(long id, String name) {

        final Company company = companyDao.selectCompanyById(id);

        if(company == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        companyDao.renameCompanyById(id,name);

        return ResponseEntity.ok("");
    }
}
