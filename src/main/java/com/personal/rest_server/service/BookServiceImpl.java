package com.personal.rest_server.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.rest_server.dto.BookDto;
import com.personal.rest_server.entity.Book;
import com.personal.rest_server.exception.BookNotFoundException;
import com.personal.rest_server.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service(value = "BookService")
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public void addBook(BookDto bookDto) throws BookNotFoundException {
		if(bookDto.getId() != null && bookRepository.existsById(bookDto.getId())) {
			Book book = bookRepository.findById(bookDto.getId()).get();
			mapper.map(bookDto, book);
			bookRepository.save(book);
		} else {
			Book book = mapper.map(bookDto, Book.class);
			bookRepository.save(book);
		}
	}

	@Override
	public void removeBook(Long id) throws BookNotFoundException {
		Optional<Book> book = Optional.ofNullable(bookRepository.findById(id))
				.orElseThrow(() -> new BookNotFoundException("Books not found"));
		bookRepository.delete(book.get());

	}

	@Override
	public List<BookDto> getAll() throws BookNotFoundException {
		return Optional.ofNullable(bookRepository.findAll())
				.orElseThrow(() -> new BookNotFoundException("No books found"))
				.stream()
				.map(e -> mapper.map(e, BookDto.class))
				.collect(Collectors.toList());
	}

}
