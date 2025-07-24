package com.personal.rest_server.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.personal.rest_server.dto.BookDto;
import com.personal.rest_server.dto.BorrowedBookDto;
import com.personal.rest_server.dto.ResponseDto;
import com.personal.rest_server.exception.BookNotFoundException;
import com.personal.rest_server.service.BookService;
import com.personal.rest_server.service.BorrowedBookService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping(value = "/library")
public class LibraryAPI {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BorrowedBookService bBookService;
	
	@PostMapping
	public ResponseEntity<ResponseDto> addBook(@RequestBody BookDto bookDto) throws BookNotFoundException {
		bookService.addBook(bookDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Book added");
		ResponseEntity<ResponseDto> response = new ResponseEntity<ResponseDto> (responseDto, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value = "/books")
	public ResponseEntity<List<BookDto>> getAllBooks() throws BookNotFoundException {
		List<BookDto> books = bookService.getAll();
		ResponseEntity<List<BookDto>> response = new ResponseEntity<List<BookDto>>(books, HttpStatus.OK);
		return response;
	}
	
	@PutMapping(value = "/books")
	public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto) throws BookNotFoundException {
		bookService.addBook(bookDto);
		ResponseEntity<String> response = new ResponseEntity<String> ("Book updated.", HttpStatus.OK);
		return response;
	} 
	
	@DeleteMapping(value = "/books")
	public ResponseEntity<ResponseDto> deleteBook(@RequestParam(name = "id") Long id) throws BookNotFoundException {
		bookService.removeBook(id);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Book deleted.");
		ResponseEntity<ResponseDto> response = new ResponseEntity<ResponseDto> (responseDto, HttpStatus.OK);
		return response;
	}
	
	@PostMapping(value = "/borrowBook")
	public ResponseEntity<ResponseDto> borrowBook(@RequestBody BorrowedBookDto bookDto) throws BookNotFoundException {
		bBookService.addBorrowedBook(bookDto);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Book added");
		ResponseEntity<ResponseDto> response = new ResponseEntity<ResponseDto> (responseDto, HttpStatus.OK);
		return response;
	}
	
	@PutMapping(value = "/returnBook")
	public ResponseEntity<ResponseDto> returnBook(@RequestBody Map<String, Long> body) throws BookNotFoundException {
		Long id = body.get("id");
		bBookService.returnBook(id);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("Book returned");
		ResponseEntity<ResponseDto> response = new ResponseEntity<ResponseDto> (responseDto, HttpStatus.OK);
		return response;
	}
	
}
