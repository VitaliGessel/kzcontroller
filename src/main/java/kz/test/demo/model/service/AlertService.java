package kz.test.demo.model.service;

import kz.test.demo.model.entity.Alert;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlertService {

    ResponseEntity<List<Alert>> selectAllUsersWithAlert();

    ResponseEntity<String> createNewAlertForUser(Alert alert);

    ResponseEntity<String> updateAlertForUser(long id, String alert_type, boolean value);

}
