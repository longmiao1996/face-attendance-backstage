package com.movie.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.movie.dao.MeetingDao_p;
import com.movie.domain.Meeting_p;
import com.movie.service.MeetingService_p;
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("meetingService_p")
public class MeetingServiceImpl implements MeetingService_p{
	@Autowired
	private MeetingDao_p meetingDao_p;
	@Override
	public void addMeeting(Meeting_p meeting_p) {
		// TODO Auto-generated method stub
		meetingDao_p.addMeeting(meeting_p);
	}
	@Override
	public Meeting_p selectByState() {
		// TODO Auto-generated method stub
		return meetingDao_p.selectByState();
	}
	@Override
	public void updateMeetingState(Integer id) {
		// TODO Auto-generated method stub
		meetingDao_p.updateMeetingState(id);
	}

}
