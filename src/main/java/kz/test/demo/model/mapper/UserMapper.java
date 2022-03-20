package kz.test.demo.model.mapper;

import kz.test.demo.model.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        final User user = new User();

        user.setId(rs.getLong("id"));
        user.setCompanyId(rs.getLong("company_id"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setCode(rs.getLong("code"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getLong("phone"));
        user.setPhone(rs.getLong("telegram_id"));

        return user;
    }
}
