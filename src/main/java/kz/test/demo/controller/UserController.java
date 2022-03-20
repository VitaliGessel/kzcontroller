package kz.test.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import kz.test.demo.model.entity.User;
import kz.test.demo.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json")
@Api(value = "/users", tags = {"Сотрудники компаний"})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.readAllUsers();
    }






    @PostMapping
    public ResponseEntity<String> insertNewUser(
            @RequestBody final User user
    ) {
        return userService.createNewUser(user);
    }




    @PutMapping("/{id}/")
    public String updateUser(

            @ApiParam(
                    value = "id сотрудника в базе",
                    name = "id",
                    required = true,
                    example = "1"
            )
            @PathVariable(value = "id" ) final long id,


            @ApiParam(
                    value = "Имя сотрудника",
                    name = "name",
                    required = true,
                    example = "Иван"
            )
            @RequestParam(value = "name") final String name,

            @ApiParam(
                    value = "Фамилия сотрудника",
                    name = "surname",
                    example = "Иванов"
            )
            @RequestParam(value = "surname" , required = false) final String surname,


            @ApiParam(
                    value = "Id компании сотрудника",
                    name = "company_id",
                    required = true,
                    example = "1"
            )
            @RequestParam(value = "company_id" ) final String company_id,

            @ApiParam(
                    value = "Номер телефона сотрудника",
                    name = "phone",
                    example = "1"
            )
            @RequestParam(value = "phone" , required = false) final String phone,

            @ApiParam(
                    value = "Email сотрудника",
                    name = "phone",
                    example = "1"
            )
            @RequestParam(value = "email" , required = false) final String email,

            @ApiParam(
                    value = "Код телеграма сотрудника",
                    name = "phone",
                    example = "1"
            )
            @RequestParam(value = "telegram_id", required = false)  String telegram_id


    ) {

        return name + " " + surname + " "+company_id + " "+phone+ " "+email+" "+telegram_id+ " where id=" + id;
    }


}
