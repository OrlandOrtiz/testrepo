package com.personal.rest_server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.personal.rest_server.dto.EmployeeDto;
import com.personal.rest_server.exception.ServerException;

@Service
public interface EmployeeService {
	public List<EmployeeDto> getAllEmployees() throws ServerException;
}
