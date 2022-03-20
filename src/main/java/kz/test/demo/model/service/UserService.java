package kz.test.demo.model.service;

import kz.test.demo.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<List<User>> readAllUsers();

    ResponseEntity<String> createNewUser(User user);
}
