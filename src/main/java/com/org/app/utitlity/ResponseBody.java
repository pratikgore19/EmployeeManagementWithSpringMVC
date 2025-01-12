package com.org.app.utitlity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody {
	
	private int statusCode;
	private String message;
	private LocalDateTime timeStamp;

}
