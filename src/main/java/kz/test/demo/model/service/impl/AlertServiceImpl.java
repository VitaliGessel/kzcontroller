package kz.test.demo.model.service.impl;


import kz.test.demo.dao.AlertDao;
import kz.test.demo.dao.UserDao;
import kz.test.demo.model.entity.Alert;
import kz.test.demo.model.entity.User;
import kz.test.demo.model.entity.AlertsTypesPortal;
import kz.test.demo.model.service.AlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    private final AlertDao alertDao;
    private final UserDao userDao;

    public AlertServiceImpl(AlertDao alertDao, UserDao userDao) {
        this.alertDao = alertDao;
        this.userDao = userDao;
    }

    @Override
    public ResponseEntity<List<Alert>> selectAllUsersWithAlert() {
        return ResponseEntity.ok(alertDao.selectAllUsersAlertStatus());
    }

    @Override
    public ResponseEntity<String> createNewAlertForUser(Alert alert) {

        if (alert.getUserId() == 0) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // пересмотреть эту ошибку и добавить что пользоваеля такого не существует 404
        }

        alertDao.insertAlertStatusForUser(alert);
        return ResponseEntity.ok("");
    }


    @Override
    public ResponseEntity<String> updateAlertForUser(long id, String alert_type, boolean value) {
        boolean alertsTypesPortal = AlertsTypesPortal.getAlertTypesPortal(alert_type);

        final User user = userDao.selectUserById(id);

        if (user == null) {
            System.out.println("user not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        if (!alertsTypesPortal) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


        final Alert alert = alertDao.selectAlertByUserId(id);
        if (alert == null) {

            Alert createNewAlert = new Alert();
            createNewAlert.setUserId(id);
            alertDao.insertAlertStatusForUser(createNewAlert);

            //System.out.println("Create alert" + createNewAlert.getUserId());
        }

        alertDao.updateAlertStatusForUser(id, alert_type, value);

        return ResponseEntity.ok("");
    }
}
