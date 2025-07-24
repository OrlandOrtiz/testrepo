package com.personal.rest_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.personal.rest_server.service.EmployeeService;

@WebMvcTest(CustomerAPI.class)
public class CustomerAPITest {
	
	@Autowired
	CustomerAPI customerApi;
	
	@MockBean
	private EmployeeService employeeService; 

}
