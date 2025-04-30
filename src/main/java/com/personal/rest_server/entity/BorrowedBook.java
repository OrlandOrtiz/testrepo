package com.personal.rest_server.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BORROWEDBOOK")
public class BorrowedBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
	@SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", allocationSize = 1)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "BOOKID")
	private Book book;
	
	@Column(name = "BORROWEDBYUSERID")
	private Long borrowedByUserId;
	
	@Column(name = "BORROWDATE")
	private Date borrowedDate;
	
	@Column(name = "RETURNDATE")
	private Date returnDate;
	
	@Column(name = "ISRETURNED")
	private Integer isReturned;
	
}
