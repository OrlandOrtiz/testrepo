package com.personal.rest_server.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.personal.rest_server.dto.BookDto;
import com.personal.rest_server.exception.BookNotFoundException;

@Service
public interface BookService {

	public void addBook(BookDto bookDto) throws BookNotFoundException;
	public void removeBook(Long id) throws BookNotFoundException;
	public List<BookDto> getAll() throws BookNotFoundException;
}
