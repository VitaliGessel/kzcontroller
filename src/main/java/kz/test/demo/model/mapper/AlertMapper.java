package kz.test.demo.model.mapper;


import kz.test.demo.model.entity.Alert;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlertMapper implements RowMapper<Alert> {

    @Override
    public Alert mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Alert alert = new Alert();
        alert.setUserId(rs.getLong("user_id"));
        alert.setAlertSms(rs.getBoolean("alert_sms"));
        alert.setAlertEmail(rs.getBoolean("alert_email"));
        alert.setAlertTelegram(rs.getBoolean("alert_telegram"));
        return alert;

    }
}


