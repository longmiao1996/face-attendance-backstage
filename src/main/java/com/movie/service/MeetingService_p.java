package com.movie.service;

import com.movie.domain.Meeting_p;

public interface MeetingService_p {
	void addMeeting(Meeting_p meeting_p);
	Meeting_p selectByState();
	void updateMeetingState(Integer id);
}
