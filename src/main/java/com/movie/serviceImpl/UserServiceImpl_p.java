package com.movie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.movie.dao.UserDao_p;
import com.movie.domain.User_p;
import com.movie.service.UserService_p;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService_p")
public class UserServiceImpl_p implements UserService_p{
	@Autowired
	private UserDao_p userDao_p;
	@Override
	public void insert(User_p user_p) {
		// TODO Auto-generated method stub
		userDao_p.addUser(user_p);
	}
	@Override
	public String image_p(Integer id) {
		// TODO Auto-generated method stub
		return userDao_p.selectById(id);
	}
	@Override
	public List<User_p> findAllImage() {
		// TODO Auto-generated method stub
		return userDao_p.findAllImage();
	}
	@Override
	public List<User_p> findAll() {
		// TODO Auto-generated method stub
		return userDao_p.findAll();
	}
	@Override
	public User_p selectByIds(Integer id) {
		// TODO Auto-generated method stub
		return userDao_p.selectByIds(id);
	}
	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userDao_p.deleteUser(id);
	}
	@Override
	public Integer selectId1() {
		// TODO Auto-generated method stub
		return userDao_p.selectId1();
	}

}
