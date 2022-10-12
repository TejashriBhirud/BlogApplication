package com.BlogApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BlogApplication.entity.Blogs;

public interface BlogsRepo extends JpaRepository<Blogs, Integer> {

}
