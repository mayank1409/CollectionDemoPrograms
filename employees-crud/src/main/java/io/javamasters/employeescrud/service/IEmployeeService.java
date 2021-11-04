package io.javamasters.employeescrud.service;

import io.javamasters.employeescrud.entity.EmployeeEntity;
import io.javamasters.employeescrud.service.base.IGenericService;

public interface IEmployeeService extends IGenericService<EmployeeEntity, Long> {

    //// all crud methods inherited

    //// employees specific methods
    public EmployeeEntity findBYEmailAddress(String emailAddress);

}
