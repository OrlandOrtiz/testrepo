package com.personal.rest_server.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.stereotype.Service;
import com.personal.rest_server.dto.EmployeeDto;
import com.personal.rest_server.entity.Employee;
import com.personal.rest_server.exception.ServerException;
import com.personal.rest_server.repository.EmployeeRepository;
import jakarta.transaction.Transactional;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<EmployeeDto> getAllEmployees() throws ServerException {			
		return Optional.ofNullable(employeeRepository.findAll())
				.orElseThrow(() -> new ServerException("Service.EMPLOYEE_NOT_FOUND"))
				.stream()
				.map(e -> modelMapper.map(e, EmployeeDto.class))
				.collect(Collectors.toList());
		
	}
	
	
}
