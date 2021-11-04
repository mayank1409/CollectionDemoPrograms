package io.javamasters.employeescrud.controllers;

import io.javamasters.employeescrud.dtos.EmployeeDTO;
import io.javamasters.employeescrud.entity.EmployeeEntity;
import io.javamasters.employeescrud.service.IEmployeeService;
import io.javamasters.employeescrud.transformers.impl.EmployeeEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeEntityController {
    @Autowired
    EmployeeEntityTransformer employeeEntityTransformer;
    @Autowired
    IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<EmployeeDTO>(employeeEntityTransformer.toDTO(employeeService.save(employeeEntityTransformer.fromDTO(employeeDTO))), CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> list() {
        return new ResponseEntity<List<EmployeeDTO>>(employeeEntityTransformer.toListDTO(employeeService.list()), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> get(@PathVariable("id") Long id) {
        return new ResponseEntity<EmployeeDTO>(employeeEntityTransformer.toDTO(employeeService.get(id)), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") Long id) {
        EmployeeEntity employeeEntity = employeeEntityTransformer.fromDTO(employeeDTO);
        employeeEntity.setId(id);
        return new ResponseEntity<EmployeeDTO>(employeeEntityTransformer.toDTO(employeeService.update(employeeEntity, id)), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
