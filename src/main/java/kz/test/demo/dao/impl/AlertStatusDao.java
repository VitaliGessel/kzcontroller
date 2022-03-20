package kz.test.demo.dao.impl;

import kz.test.demo.dao.AlertDao;
import kz.test.demo.dao.BaseDao;
import kz.test.demo.model.entity.Alert;
import kz.test.demo.model.mapper.AlertMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlertStatusDao extends BaseDao implements AlertDao {

    @Override
    public List<Alert> selectAllUsersAlertStatus() {
        final String sql = "Select id,user_id,alert_sms,alert_email,alert_telegram from c_alert";
        return jdbcTemplate.query(sql, new AlertMapper());
    }

    @Override
    public void insertAlertStatusForUser(Alert alert) {
        if (alert.getUserId() == 0) {
            return;
        }

        final String sql = String.format("Insert Into c_alert (user_id, alert_sms, alert_email, alert_telegram) Values ('%s','%s','%s','%s')",
                alert.getUserId(), alert.isAlertSms(), alert.isAlertEmail(), alert.isAlertTelegram());
        jdbcTemplate.update(sql);
    }

    @Override
    public Alert selectAlertByUserId(long id) {
        final String sql = String.format("Select id, user_id, alert_sms, alert_email, alert_telegram from c_alert Where user_id = '%s'", id);

        //System.out.println(sql);
        try {
            return jdbcTemplate.queryForObject(sql, new AlertMapper());
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateAlertStatusForUser(long id, String alert_type, boolean value) {

        String rowInDb;
        switch (alert_type) {
            case "telegram":
                rowInDb = "alert_telegram";
                break;

            case "sms":
                rowInDb = "alert_sms";
                break;
            case "email":
                rowInDb = "alert_email";
                break;
            default:
                rowInDb = "";


        }
        final String sql = String.format("Update  c_alert Set %s='%s' where user_id='%s' ", rowInDb, value, id);

        jdbcTemplate.update(sql);
        //System.out.println(sql);

    }
}
