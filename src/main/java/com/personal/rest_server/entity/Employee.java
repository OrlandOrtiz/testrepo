package com.personal.rest_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer emp_id;
	private String job;
	private Integer salary;
	private Integer deptno;
	
	
}
