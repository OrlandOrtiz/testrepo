package com.personal.rest_server.dto;

import lombok.Data;

@Data
public class BookDto {

	private Long id;
	private String title;
	private String author;
	private String genre;
	private String status;
}
