package com.BlogApplication.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BlogsDto {
 
	private int id;
	private String title;
	private String discription;
	private Date creationDate;
	
}
