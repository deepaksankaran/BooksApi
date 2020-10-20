package com.BooksApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BooksApi.model.UserDao;

public interface UserRepository extends JpaRepository<UserDao, Integer> {
	
    UserDao findByUsername(String username);
}