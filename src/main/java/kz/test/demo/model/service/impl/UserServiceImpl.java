package kz.test.demo.model.service.impl;

import kz.test.demo.dao.CompanyDao;
import kz.test.demo.dao.UserDao;
import kz.test.demo.model.entity.Company;
import kz.test.demo.model.entity.User;
import kz.test.demo.model.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final CompanyDao companyDao;


    public UserServiceImpl(UserDao userDao, CompanyDao companyDao) {

        this.userDao = userDao;
        this.companyDao = companyDao;
    }

    @Override
    public ResponseEntity<List<User>> readAllUsers() {
        return ResponseEntity.ok(userDao.selectAllUsers());
    }

    @Override
    public ResponseEntity<String> createNewUser(User user) {

        final Company company = companyDao.selectCompanyById(user.getCompanyId());



        if (company == null) {
            System.out.println(user.getCompanyId());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        userDao.insertNewUser(user);
        return ResponseEntity.ok("");
    }
}
