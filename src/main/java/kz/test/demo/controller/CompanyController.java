package kz.test.demo.controller;

import io.swagger.annotations.*;
import kz.test.demo.model.entity.Company;
import kz.test.demo.model.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company", produces = "application/json")
@Api(value = "/company", tags = {"Компании"})
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    @ApiOperation(
            value = "Получить список компаний",
            httpMethod = "GET",
            produces = "application/json",
            response = Company.class
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка")
            }
    )
    public ResponseEntity<List<Company>> getAllCompany() {
        return companyService.readAllCompany();
    }






    @PutMapping("/{id}/{name}")
    @ApiOperation(
            value = "Изменить название компании",
            httpMethod = "PUT"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Компания не найдена"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка")
            }
    )
    public ResponseEntity<String> renameCompanyById(
            @ApiParam(
                    value = "id компании в базе",
                    name = "id",
                    required = true,
                    example = "1"
            )
            @PathVariable(value = "id") final long id,

            @ApiParam(
                    value = "Наименование компании",
                    name = "name",
                    required = true,
                    example = "MusterCompany"
            )
            @PathVariable(value = "name") final String name
    ) {
        return companyService.updateCompanyById(id,name);
    }



    @PostMapping()
    @ApiOperation(
            value = "Добавить новую компанию",
            httpMethod = "POST"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Компания успешно вставлена"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка")
            }
    )
    public ResponseEntity<String> insertNewCompany(
            @ApiParam(
                    value = "Название компании",
                    name = "name",
                    required = true,
                    example = "MusterCompany"
            )
            @RequestBody final Company company
    )
    {
        return companyService.createNewCompany(company);
    }





    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Удалить компанию",
            httpMethod = "DELETE"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "OK"),
                    @ApiResponse(code = 404, message = "Компания не найдена"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка")
            }
    )
    public ResponseEntity<String> deleteCompanyById(
            @ApiParam(
                    value = "id компании в базе",
                    name = "id",
                    required = true,
                    example = "1"
            )
            @PathVariable(value = "id") final long id
    )
    {
        return companyService.deleteCompanyById(id);
    }

}
