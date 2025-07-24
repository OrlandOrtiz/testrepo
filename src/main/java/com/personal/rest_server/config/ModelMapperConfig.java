package com.personal.rest_server.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.personal.rest_server.dto.EmployeeDto;
import com.personal.rest_server.entity.Employee;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {		
		return new ModelMapper();
	}
	
	


}
