package com.personal.rest_server.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeDto {
	
	@NotNull(message = "{EMPLOYEE.ID.NOT_NULL}")
	private Integer emp_id;
	private String job;
	private Integer salary;
	private Integer deptno;
	
	
	
	
}
