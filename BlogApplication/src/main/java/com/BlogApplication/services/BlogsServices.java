package com.BlogApplication.services;

import java.util.List;

import com.BlogApplication.payloads.BlogsDto;

public interface BlogsServices {

	BlogsDto createBlog(BlogsDto blogsDto);
	
	BlogsDto updateBlog(BlogsDto blogsDto, Integer blogId);
	
	BlogsDto getBlogById(Integer blogId);
	
	List<BlogsDto>getAllBlogs();
	
	void deleteBlog(Integer blogId);
	
}
