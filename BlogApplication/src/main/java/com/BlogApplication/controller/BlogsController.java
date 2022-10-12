package com.BlogApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlogApplication.payloads.ApiResponse;
import com.BlogApplication.payloads.BlogsDto;
import com.BlogApplication.services.BlogsServices;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

	@Autowired
	private BlogsServices blogsServices;
	
	//POST -create blogs  http://localhost:8080/blogs/add
	
	@PostMapping("/add")
	public ResponseEntity<BlogsDto> createBlgs(@RequestBody BlogsDto blogsDto){
		BlogsDto createBlogsDto = this.blogsServices.createBlog(blogsDto);
		return new ResponseEntity<>(createBlogsDto , HttpStatus.CREATED);
}
	
	
	//PUT - update blogs  http://localhost:8080/blogs/?
	//ex -(http:/localhost:8080/blogs/2)
	
	@PutMapping("/{blogId}")
	public ResponseEntity<BlogsDto> updateBlogs(@RequestBody BlogsDto blogsDto , @PathVariable() Integer blogId){
		
		BlogsDto updateBlogs = this.blogsServices.updateBlog(blogsDto, blogId);
		return ResponseEntity.ok(updateBlogs);
	}
	
	
	
	//DELETE -delete blogs http://localhost:8080/blogs/?
	
	@DeleteMapping("/{blogId}")
	public ResponseEntity<ApiResponse> deleteBlogs(@PathVariable() Integer blogId){
		this.blogsServices.deleteBlog(blogId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Blog deleted successfully" , true),HttpStatus.OK);
	}
	
	
	
	//GET- fetching data of blogs  http://localhost:8080/blogs/
	
	@GetMapping("/")
	public ResponseEntity<List<BlogsDto>> getAllBlogs(){
		return ResponseEntity.ok(this.blogsServices.getAllBlogs());
	}
	
	
	
	//GET by id   http://localhost:8080/blogs/?
	
	@GetMapping("/{userId}")
	public ResponseEntity<BlogsDto> getBlogById(@PathVariable() Integer userId){
		return ResponseEntity.ok(this.blogsServices.getBlogById(userId));
	}
	

}
