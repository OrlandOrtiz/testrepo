package com.personal.rest_server.dto;

import java.util.Date;

import com.personal.rest_server.entity.Book;

import lombok.Data;

@Data
public class BorrowedBookDto {
	
	private Long id;
	private Long bookId;
	private Long borrowedByUserId;
	private Date borrowedDate;
	private Date returnDate;
	private Integer isReturned;
	

}
