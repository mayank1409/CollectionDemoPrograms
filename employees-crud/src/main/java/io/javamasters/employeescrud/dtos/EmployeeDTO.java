package io.javamasters.employeescrud.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String password;
}
