package com.personal.rest_server.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.personal.rest_server.dto.BorrowedBookDto;
import com.personal.rest_server.exception.BookNotFoundException;

@Service
public interface BorrowedBookService {
	
	public void addBorrowedBook(BorrowedBookDto bookDto) throws BookNotFoundException;
	public void removeBook(Long id) throws BookNotFoundException;
	public List<BorrowedBookDto> getAll() throws BookNotFoundException;
	public void returnBook(Long id) throws BookNotFoundException;

}
