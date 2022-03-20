package kz.test.demo.dao.impl;

import kz.test.demo.dao.BaseDao;
import kz.test.demo.dao.UserDao;
import kz.test.demo.model.entity.User;
import kz.test.demo.model.mapper.UserMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public User selectUserById(long id) {
        final String sql = "select id,name,surname,company_id,code,email,phone,telegram_id from c_users where id = " + id;

        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper());
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<User> selectAllUsers() {

        final String sql = "select id,name,surname,company_id,code,email,phone,telegram_id from c_users";

        return jdbcTemplate.query(sql, new UserMapper());
    }


    @Override
    public void insertNewUser(User user) {

        if(user.getName() == null)
        {
            return;
        }

        String randomValue = "123456";

        final String sql =  String.format("Insert into c_user (name, surname, company_id, code, email, phone, telegram_id) Values ('%s','%s','%s','%s','%s','%s','%s') ",
                user.getName(), user.getSurname(), user.getCompanyId(), randomValue, user.getEmail(),user.getPhone(),user.getTelegramId());

        System.out.println(sql);
        //jdbcTemplate.update(sql);

    }
}
