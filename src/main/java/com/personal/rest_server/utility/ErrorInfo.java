package com.personal.rest_server.utility;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorInfo {
	private String errorMesage;
	private Integer errorcode;
	private LocalDateTime timestamp;
}
