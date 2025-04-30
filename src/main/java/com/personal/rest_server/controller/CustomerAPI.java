package com.personal.rest_server.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.personal.rest_server.dto.EmployeeDto;
import com.personal.rest_server.exception.ServerException;
import com.personal.rest_server.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/customer")
public class CustomerAPI {
	
	@Autowired
	private EmployeeService employeeService; 
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam String id) throws ServerException {	
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		ResponseEntity<List<EmployeeDto>> response = new ResponseEntity<List<EmployeeDto>>(employees, HttpStatus.OK);
		return response;		
		
	}
	
	@PostMapping(value = "/body")
	public ResponseEntity<String> getMessageBody(@Valid @RequestBody EmployeeDto id) {		
		ResponseEntity<String> response = new ResponseEntity<String>("create response", HttpStatus.OK);
		return response;
	}
	
	@PutMapping(value = "/consumer/update")
	public ResponseEntity<String> updateConsumer(@RequestBody EmployeeDto dto) {
		String s = "";
		ResponseEntity<String> response = new ResponseEntity<String>("update response" + s, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping(value = "/consumer/{id}")
	public ResponseEntity<String> deleteConsumer(@PathVariable Integer id) {
		ResponseEntity<String> response = new ResponseEntity<String>("delete response", HttpStatus.OK);
		return response;
	} 
	
	
	
}
