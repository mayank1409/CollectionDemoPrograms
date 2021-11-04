package io.javamasters.employeescrud.transformers.impl;

import io.javamasters.employeescrud.dtos.EmployeeDTO;
import io.javamasters.employeescrud.entity.EmployeeEntity;
import io.javamasters.employeescrud.exceptions.EntityAlreadyExistsException;
import io.javamasters.employeescrud.service.impl.EmployeeEntityService;
import io.javamasters.employeescrud.transformers.IGenericTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PersistenceException;
import javax.swing.plaf.ListUI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Component
public class EmployeeEntityTransformer implements IGenericTransformer<EmployeeEntity, EmployeeDTO> {

    @Autowired
    private EmployeeEntityService employeeEntityService;

    @Override
    public EmployeeEntity fromDTO(EmployeeDTO employeeDTO) {
        EmployeeEntity employee = employeeEntityService.findBYEmailAddress(employeeDTO.getEmailAddress());

        if (employee != null) {
            throw new EntityAlreadyExistsException("Entity Already Exists");
        }

        employee = EmployeeEntity.builder().firstName(employeeDTO.getFirstName()).
                lastName(employeeDTO.getLastName()).emailAddress(employeeDTO.getEmailAddress())
                .password(Base64.getEncoder().encodeToString(employeeDTO.getPassword().getBytes(StandardCharsets.UTF_8))).build();
        return employee;
    }

    @Override
    public EmployeeDTO toDTO(EmployeeEntity employeeEntity) {
        return EmployeeDTO.builder().id(employeeEntity.getId()).firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName()).emailAddress(employeeEntity.getEmailAddress()).build();
    }

}
