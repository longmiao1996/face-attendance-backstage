package com.movie.service;

import java.util.List;

import com.movie.domain.User_p;

public interface UserService_p {
	void insert(User_p user_p);
	String image_p(Integer id);
	List<User_p> findAllImage();
	List<User_p> findAll();
	User_p selectByIds(Integer id);
	void deleteUser(Integer id);
	Integer selectId1();
}
