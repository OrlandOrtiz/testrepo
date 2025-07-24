package com.personal.rest_server.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.rest_server.dto.BookDto;
import com.personal.rest_server.dto.BorrowedBookDto;
import com.personal.rest_server.entity.Book;
import com.personal.rest_server.entity.BorrowedBook;
import com.personal.rest_server.exception.BookNotFoundException;
import com.personal.rest_server.repository.BookRepository;
import com.personal.rest_server.repository.BorrowedBookRepository;
import com.personal.rest_server.constants.AppConstants;

import jakarta.transaction.Transactional;

@Service(value = "BorrowedBookService")
@Transactional
public class BorrowedBookServiceImpl implements BorrowedBookService {
	
	@Autowired
	private BorrowedBookRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public void addBorrowedBook(BorrowedBookDto bBookDto) throws BookNotFoundException {
		BorrowedBook bBook = mapper.map(bBookDto, BorrowedBook.class);
		
		Book book = bookRepository.findById(bBookDto.getBookId())
	            .orElseThrow(() -> new BookNotFoundException("The book with the ID " + bBookDto.getBookId() + " was not found."));
		bBook.setBook(book);
		repository.save(bBook);
		
		
		book.setStatus(AppConstants.BORROWED_STATUS);
		bookRepository.save(book);

	}

	@Override
	public void removeBook(Long id) throws BookNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BorrowedBookDto> getAll() throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void returnBook(Long id) throws BookNotFoundException {
		
		Book book = bookRepository.findById(id)
	            .orElseThrow(() -> new BookNotFoundException("The book with the ID " + id + " was not found."));
		
		Optional<BorrowedBook> bBook = Optional.ofNullable(repository.findByBookAndReturnDateIsNull(book)
				.orElseThrow(() -> new BookNotFoundException("Borrowed Book not found")));
		
		bBook.get().setIsReturned(1);
		bBook.get().setReturnDate(new Date());
		repository.save(bBook.get());
		
		book.setStatus(AppConstants.AVAILABLE_STATUS);
		bookRepository.save(book);
		
	}

}
