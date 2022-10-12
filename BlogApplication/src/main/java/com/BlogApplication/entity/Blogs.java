package com.BlogApplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Blogs")
@Data
public class Blogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Discription")
	private String discription;
	
	@Column(name="CreationDate")
	private Date creationDate;
	

}
