package kz.test.demo.model.service;

import kz.test.demo.model.entity.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

    ResponseEntity<List<Company>> readAllCompany();

    ResponseEntity<String> updateCompanyById(long id, String name);

    ResponseEntity<String> createNewCompany(Company company);

    ResponseEntity<String> deleteCompanyById(long id);
}
