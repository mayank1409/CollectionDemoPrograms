package io.javamasters.employeescrud.repository;

import io.javamasters.employeescrud.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeEntityRepository extends JpaRepository<EmployeeEntity, Long> {

    public EmployeeEntity findByEmailAddress(String emailAddress);

}
