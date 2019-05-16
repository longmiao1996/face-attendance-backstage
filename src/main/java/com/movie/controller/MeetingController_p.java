package com.movie.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.domain.Meeting_p;
import com.movie.domain.User_p;
import com.movie.service.MeetingService_p;
import com.movie.service.UserService_p;

@Controller
public class MeetingController_p {
	@Autowired
	@Qualifier("meetingService_p")
	private MeetingService_p meetingse_p;
	@Autowired
	@Qualifier("userService_p")
	private UserService_p userse_p;
	
	//添加会议信息
	@RequestMapping(value="/addMeeting")
	@ResponseBody
	public void addMeetings(@ModelAttribute Meeting_p meeting_p) {
		meetingse_p.addMeeting(meeting_p);
		HashMap<String, Object> hm_m=new HashMap<String, Object>();
		//会议名称
		String name_m=meeting_p.getName_m();
		System.out.println("men:"+name_m);		
		//会议内容
		String content_m=meeting_p.getContent_m();
		System.out.println("met:"+content_m);
	}
	//跳转签到页面，返回会议相关信息
	@RequestMapping(value="/sign")
	@ResponseBody
	public HashMap<String, Object> sign(){
		HashMap<String, Object> hm_m=new HashMap<String, Object>();
		//查找会议状态为1
		Meeting_p meeting_p=meetingse_p.selectByState();
		if(meeting_p!=null) {
			//会议id
			Integer id_m=meeting_p.getId();
			System.out.println("mesn:"+id_m);		
			hm_m.put("id_m", id_m);
			//会议名称
			String name_m=meeting_p.getName_m();
			System.out.println("mesn:"+name_m);		
			hm_m.put("name_m", name_m);
			//会议内容
			String content_m=meeting_p.getContent_m();
			System.out.println("mesc:"+content_m);
			hm_m.put("content_m", content_m);
			//与会人员信息
			String[] ids_m=meeting_p.getIds_m().split(",");
			System.out.println("idss:"+meeting_p.getIds_m());
			int m=ids_m.length;
			System.out.println("ids:"+m);
			User_p arr[] = new User_p[m];//开辟数组空间
			for (int i = 0; i < m; i++) {
				int a_m = Integer.parseInt(ids_m[i]);
				System.out.println(a_m);
				User_p user_p1= userse_p.selectByIds(a_m);
				System.out.println(user_p1.getName());
		        arr[i] = new User_p(a_m,user_p1.getName(),user_p1.getImage());//对象需要分别实例化
			}
			hm_m.put("user_m", arr);
			hm_m.put("state", meeting_p.getState());
		}else {
			hm_m.put("state", 0);
		}
		return hm_m;
	}
	//结束签到，获取会议id
	@RequestMapping(value="/sign_over")
	@ResponseBody
	public void sign_over(@RequestParam("id_m") Integer id_m) {
		meetingse_p.updateMeetingState(id_m);
	}
}
