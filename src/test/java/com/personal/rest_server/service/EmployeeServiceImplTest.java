package com.personal.rest_server.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.personal.rest_server.exception.ServerException;
import com.personal.rest_server.repository.EmployeeRepository;

@WebMvcTest(EmployeeServiceImpl.class)
public class EmployeeServiceImplTest {
	
	@Autowired
	EmployeeServiceImpl em;
	
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@MockBean
	private ModelMapper modelMapper;
	
	/*@Test
	public void getAllEmployeesTest() {
		Mockito.when(employeeRepository.findAll()).thenReturn(null);
		
		assertThrows(ServerException.class, () -> em.getAllEmployees());
		
	}*/

}
