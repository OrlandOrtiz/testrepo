package com.personal.rest_server.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.personal.rest_server.entity.Book;
import com.personal.rest_server.entity.BorrowedBook;

@Repository
public interface BorrowedBookRepository  extends JpaRepository<BorrowedBook, Long> {
	
	Optional<BorrowedBook> findByBook(Book book);
	Optional<BorrowedBook> findByBookAndReturnDateIsNull(Book book);

}
