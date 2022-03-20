package kz.test.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kz.test.demo.model.entity.Alert;
import kz.test.demo.model.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alert", produces = "application/json")
@Api(value = "/alert", tags = {"Оповещение сотрудников"})
public class AlertController {

    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }



    @GetMapping
    @ApiOperation(
            value = "Получить список сотрудников с типом уведомлений",
            httpMethod = "GET",
            produces = "application/json",
            response = Alert.class
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка")
            }
    )
    public ResponseEntity<List<Alert>> getAllUsersWithAlert()
    {
        return alertService.selectAllUsersWithAlert();
    }






    @PostMapping()
    public ResponseEntity<String> insertNewAlertForUser(
            @RequestBody final Alert alert
    ) {
        return alertService.createNewAlertForUser(alert);
    }





    @PutMapping("/{id}/{alert_type}/{value}")
    public ResponseEntity<String> getStatusType(
            @PathVariable(value = "id") final long id,
            @PathVariable(value = "alert_type") final String alert_type,
            @PathVariable(value = "value") final boolean value
    )
    {

        return alertService.updateAlertForUser(id,alert_type,value);
    }
}

