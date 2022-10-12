package com.BlogApplication.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BlogApplication.entity.Blogs;
import com.BlogApplication.exception.ResourceNotFoundException;
import com.BlogApplication.payloads.BlogsDto;
import com.BlogApplication.repository.BlogsRepo;
import com.BlogApplication.services.BlogsServices;


@Service
public class BlogServiceImpl implements BlogsServices{

	@Autowired
	private BlogsRepo blogsRepo;
	
	@Override
	public BlogsDto createBlog(BlogsDto blogsDto) {
		Blogs blogs = this.dtoToBlogs(blogsDto);
		Blogs savedBlog = this.blogsRepo.save(blogs);
		return this.blogsToDto(savedBlog);
	}

	@Override
	public BlogsDto updateBlog(BlogsDto blogsDto, Integer blogId) {
		
		Blogs blogs = this.blogsRepo.findById(blogId)
				.orElseThrow(()-> new ResourceNotFoundException("Blogs", "Id", blogId));
			
		blogs.setTitle(blogsDto.getTitle());
		blogs.setDiscription(blogsDto.getDiscription());
		blogs.setCreationDate(blogsDto.getCreationDate());
		
		
		Blogs updateBlogs = this.blogsRepo.save(blogs);
		BlogsDto blogsDtoNew = this.blogsToDto(updateBlogs);
			
		return blogsDtoNew;
	}

	@Override
	public BlogsDto getBlogById(Integer blogId) {
		
		Blogs blogs = this.blogsRepo.findById(blogId)
				.orElseThrow(()-> new ResourceNotFoundException("Blogs", "Id", blogId));
		
		return blogsToDto(blogs);
	}

	@Override
	public List<BlogsDto> getAllBlogs() {
		
		List<Blogs> blogslist = this.blogsRepo.findAll();
		
		List<BlogsDto> blogsDtos = blogslist.stream().map(blogs -> this.blogsToDto(blogs)).collect(Collectors.toList());
		
		return blogsDtos;
	}

	
	@Override
	public void deleteBlog(Integer blogId) {
		Blogs blogs = this.blogsRepo.findById(blogId)
		.orElseThrow(()-> new ResourceNotFoundException("Blogs", "Id", blogId));
		
		this.blogsRepo.delete(blogs);
		
		
	}
	
	public Blogs dtoToBlogs(BlogsDto blogsDto) {
		Blogs blogs=new Blogs();
		blogs.setId(blogsDto.getId());
		blogs.setTitle(blogsDto.getTitle());
		blogs.setDiscription(blogsDto.getDiscription());
		blogs.setCreationDate(blogsDto.getCreationDate());
		return blogs;
	}

	public BlogsDto blogsToDto(Blogs blogs) {
		BlogsDto blogsDto=new BlogsDto();
		
		blogsDto.setId(blogs.getId());
		blogsDto.setTitle(blogs.getTitle());
		blogsDto.setDiscription(blogs.getDiscription());
		blogsDto.setCreationDate(blogs.getCreationDate());
		return blogsDto;
		
		
		
		
		
	}
}
