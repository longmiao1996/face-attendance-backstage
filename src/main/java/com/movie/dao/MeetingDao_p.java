package com.movie.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.movie.domain.Meeting_p;


public interface MeetingDao_p {
	@Insert("insert into meeting(id,name_m,content_m,ids_m,state) value(#{id},#{name_m},#{content_m},#{ids_m},#{state})")
	void addMeeting(Meeting_p meeting_p);
	@Select("select * from meeting where state = 1 ")
	Meeting_p selectByState();
	@Update("update meeting set state=0 where id=#{id}")
	void updateMeetingState(@Param("id") Integer id);
}
