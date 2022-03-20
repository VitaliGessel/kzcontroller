package kz.test.demo.dao;

import kz.test.demo.model.entity.User;

import java.util.List;

public interface UserDao {

    List<User> selectAllUsers();
    User selectUserById(long id);

    void insertNewUser(User user);

    //115200601932721
    //115200601932925

}
