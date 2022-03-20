package kz.test.demo.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/health")
@Api(value = "/health", tags = {"Проверка состояния сервера"})
public class IndexController {

    @GetMapping
    public String getHealthController()
    {
        return "ok";
    }
}
