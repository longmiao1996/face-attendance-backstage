package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.movie.domain.User_p;

public interface UserDao_p {
	@Insert("insert into user(id,name,image) value(#{id},#{name},#{image})")
	void addUser(User_p user_p);
	@Select("select image from user where id = #{id}")
	String selectById(@Param("id") Integer id);
	@Select("select image from user")
	List<User_p> findAllImage();
	@Select("select * from user")
	List<User_p> findAll();
	@Select("select * from user where id = #{id}")
	User_p selectByIds(@Param("id") Integer id);
	@Delete("delete from user where id = #{id}")
	void deleteUser(@Param("id") Integer id);
	@Select("select id from user order by id desc limit 1 ")
	Integer selectId1();
}
