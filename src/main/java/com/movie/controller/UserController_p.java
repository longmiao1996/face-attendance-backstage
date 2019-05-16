package com.movie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.movie.domain.User_p;
import com.movie.match.FaceMatch;
import com.movie.match.basa642Img;
import com.movie.service.UserService_p;
import com.movie.utils.Base64Util;
import com.movie.utils.FileUtil;


@Controller
public class UserController_p {
	@Autowired
	@Qualifier("userService_p")
	private UserService_p userse_p;

	/// 添加人员信息
	@RequestMapping(value = "/addUser_p")
	@ResponseBody
	public HashMap<String, Object> addUser(@ModelAttribute User_p user_p) {
		HashMap<String, Object> hm_add=new HashMap<String, Object>();
		//设置上传状态
		Integer sta=0;
		//获取最后一行id，并加1
		Integer id_l=userse_p.selectId1();
		Integer id_p=id_l+1;
		//获取图片的base64，存取本地并获取路径
		String imgBase=user_p.getImage();
		System.out.println("123abc"+imgBase);
		basa642Img base=new basa642Img();
		String imageBase=base.GenerateImage(imgBase, id_p);
		//如果图片有误，添加人员失败
		if(imageBase!=null) {
			sta=1;
			hm_add.put("state", sta);
			user_p.setId(id_p);
			user_p.setImage(imageBase);
			userse_p.insert(user_p);
		}else {
			sta=0;
			hm_add.put("state", sta);
		}
		System.out.println("id:" + id_p);
		return hm_add;
	}
	//人员管理页面
	@RequestMapping(value="/allUser")
	@ResponseBody
	public HashMap<String, Object> allUser() throws IOException{
		HashMap<String, Object> hm_all=new HashMap<String, Object>();
		List<User_p> list_all = userse_p.findAll();
		int n_all=list_all.size();
		//开辟数组空间
		User_p arr_all[] = new User_p[n_all];
		for (int i = 0; i < n_all; i++) {
			//转化数据库中路径对应的图片为base64
			byte[] bytes_all=FileUtil.readFileByBytes(list_all.get(i).getImage());
			//System.out.println("miao"+bytes_all);
			String image_all=Base64Util.encode(bytes_all);
			//System.out.println("miao"+image_all);
			//打包成对象数组
			arr_all[i] = new User_p(list_all.get(i).getId(),list_all.get(i).getName(),image_all);
			hm_all.put("user_all", arr_all);
			System.out.println(list_all.get(i).getName());
			System.out.println(list_all.get(i).getImage());
			System.out.println(list_all.get(i).getId());
		}
		return hm_all;
	}
	//删除人员信息
	@RequestMapping(value="/deleteUser")
	@ResponseBody
	public void deleteUser(@RequestParam("id") Integer id_p) {
		userse_p.deleteUser(id_p);
	}
	// 签到匹配图片
	@RequestMapping(value = "/match")
	@ResponseBody
	public HashMap<String, Object> match(@RequestParam("image_p") String image_p1, @RequestParam("id") Integer id_p) {
		// 获取数据库每个image
		HashMap<String, Object> hm=new HashMap<String, Object>();
		Boolean mat=false;
		List<User_p> list = userse_p.findAll();
		boolean flag = false;// 匹配状态标识
		for (int i = 0; i < list.size(); i++) {
			System.out.println("image1" + image_p1);
			System.out.println("list" + list.get(i).getImage());
			String image_p2 = list.get(i).getImage();
			FaceMatch facematch = new FaceMatch();
			mat = facematch.match(image_p1, image_p2);
			System.out.println(mat);
			if (mat) {
				flag = true;
				hm.put("flag", flag);
				hm.put("image1",image_p1);
				Integer id_p2=list.get(i).getId();
				System.out.println(id_p2);
				hm.put("id", id_p2);
				String name=list.get(i).getName();
				System.out.println(name);
				hm.put("name", name);
			}
				
		}

		

		// 迭代器循环
		/*
		 * Iterator it = list.iterator(); while(it.hasNext()) {
		 * System.out.println("list"+it.next()); }
		 */
		
		  /*String image_p2= userse_p.image_p(id_p);
		  System.out.println("img"+image_p2);
		  //String image_p2="E:\\sts\\sts-bundle\\workspace\\springboot-mybatis-demo0\\src\\main\\webapp\\images\\spring1.jpg";
		  FaceMatch facematch=new FaceMatch(); 
		  Boolean mat= facematch.match(image_p1,image_p2); 
		  System.out.println(mat);*/
		return hm;

	}

	// 上传信息，返回在职人员和访客的状态
	@RequestMapping(value = "/upload_p")
	@ResponseBody
	public HashMap<String, Object> upload_p(@RequestParam("image_p") String image_p1,@RequestParam("id") Integer id_p,@RequestParam("name") String name_p) {
		HashMap<String, Object> hm_upload=new HashMap<String, Object>();
		boolean state_p = false;
		boolean state_id = false;
		if (id_p == null) {
			state_p = false;
			hm_upload.put("state", state_p);
			hm_upload.put("name", name_p);
			hm_upload.put("image1",image_p1);
			System.out.println("v:"+name_p);
		} else {
			// 查找是否是在职人员
			User_p user_p1= userse_p.selectByIds(id_p);
			if (user_p1 != null) {
				state_p = true;
				state_id=true;
				hm_upload.put("state", state_p);
				hm_upload.put("state_id", state_id);
				hm_upload.put("id", id_p);
				hm_upload.put("name", user_p1.getName());
				hm_upload.put("image1",image_p1);
				System.out.println("w:"+user_p1.getName());
			}else {
				state_p = true;
				state_id=false;
				hm_upload.put("state", state_p);
				hm_upload.put("state_id", state_id);
				hm_upload.put("image1",image_p1);
				System.out.println("id不存在");
			}
		}
		return hm_upload;
	}
	
	//select标签传入数组
	@RequestMapping(value="/options")
	@ResponseBody
	public HashMap<String, Object> options() {
		HashMap<String, Object> hm_op=new HashMap<String, Object>();
		List<User_p> list_op = userse_p.findAll();
		int n=list_op.size();
		User_p arr_op[] = new User_p[n];//开辟数组空间
//		String[] names = new String[n];
		for (int i = 0; i < n; i++) {
			arr_op[i] = new User_p(list_op.get(i).getId(),list_op.get(i).getName(),list_op.get(i).getImage());
			hm_op.put("user_op", arr_op);
			System.out.println(list_op.get(i).getName());
		}
		return hm_op;
	}
	//选中option，获取前端id数组，返回对应id和name的map
	@RequestMapping(value="/options_ok", method = {RequestMethod.POST})
	@ResponseBody
	public HashMap<String, Object> options_ok(@RequestParam("options") String options) throws IOException{
		//拆分字符串为字符数组
		String[] ops=options.split(",");
		int m=ops.length;
		User_p arr[] = new User_p[m];//开辟数组空间
		System.out.println(arr.toString());
		HashMap<String, Object> hm_opok=new HashMap<String, Object>();
		for (int i = 0; i < m; i++) {
			//获取id对应的所有信息
			int a_opok = Integer.parseInt(ops[i]);
			System.out.println(a_opok);
			User_p user_p1= userse_p.selectByIds(a_opok);
			System.out.println(user_p1.getName());
			//转化数据库中路径对应的图片为base64
			byte[] bytes=FileUtil.readFileByBytes(user_p1.getImage());
			String image_p=Base64Util.encode(bytes);
			//打包成对象数组
	        arr[i] = new User_p(a_opok,user_p1.getName(),image_p);//对象需要分别实例化
		}
		hm_opok.put("user_opok", arr);
		return hm_opok;
	}
}
