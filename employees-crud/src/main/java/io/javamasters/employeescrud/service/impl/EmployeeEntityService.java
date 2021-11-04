package io.javamasters.employeescrud.service.impl;

import io.javamasters.employeescrud.entity.EmployeeEntity;
import io.javamasters.employeescrud.repository.IEmployeeEntityRepository;
import io.javamasters.employeescrud.service.IEmployeeService;
import io.javamasters.employeescrud.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEntityService extends AbstractService<EmployeeEntity, Long> implements IEmployeeService {

    @Autowired
    private IEmployeeEntityRepository employeeEntityRepository;

    @Override
    protected JpaRepository<EmployeeEntity, Long> repository() {
        return employeeEntityRepository;
    }

    @Override
    public EmployeeEntity findBYEmailAddress(String emailAddress) {
        EmployeeEntity employee = employeeEntityRepository.findByEmailAddress(emailAddress);
        if (employee == null) {
            return  null;
        }
        return employee;
    }
}
