package kz.test.demo.dao;

import kz.test.demo.model.entity.Alert;

import java.util.List;

public interface AlertDao {

    List<Alert> selectAllUsersAlertStatus();
    Alert selectAlertByUserId(long id);

    void insertAlertStatusForUser(Alert alert);
    void updateAlertStatusForUser(long id, String alert_type, boolean value);

}
