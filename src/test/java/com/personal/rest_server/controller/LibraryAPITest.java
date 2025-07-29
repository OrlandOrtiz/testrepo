package com.personal.rest_server.controller;

import com.personal.rest_server.dto.BookDto;
import com.personal.rest_server.exception.BookNotFoundException;
import com.personal.rest_server.service.BookService;
import com.personal.rest_server.service.BorrowedBookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(MockitoExtension.class)
public class LibraryAPITest {

    @Mock
    private BookService bookService;

    @Mock
    private BorrowedBookService borrowedBookService;

    @InjectMocks
    private LibraryAPI libraryAPI;

    private List<BookDto> books;

    @BeforeEach
    void setup() {
        books = List.of(BookDto.builder()
                .id(1234L)
                .title("title")
                .author("author")
                .genre("genre")
                .status("status")
                .build());
    }

    @Test
    public void getAllBooksTest() throws BookNotFoundException {
        when(bookService.getAll()).thenReturn(books);

        ResponseEntity<List<BookDto>> response = libraryAPI.getAllBooks();

        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("title", response.getBody().get(0).getTitle());
    }

}
