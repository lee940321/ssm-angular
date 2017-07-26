package app.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import app.user.dto.LoginUser;
import app.user.model.User;
import app.user.services.UserService;
import app.util.DateUtils;
import app.util.SessionUtils;
import app.util.exception.OrtException;

@RequestMapping("/user")
@Controller("UserController")
public class userCtrl {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public LoginUser login(@RequestBody User user, HttpServletRequest request){
		User u = userService.getUserByPhone(user.getPhone());
		System.out.println(u.getUsername());
		if(null!=u){
			if(user.getPassword().equals(u.getPassword())){
				HttpSession session = request.getSession();
				LoginUser loginUser = new LoginUser();
				loginUser.setUserId(u.getUserid());
				loginUser.setPhone(u.getPhone());
				loginUser.setUserName(u.getUsername());
				loginUser.setRole(u.getRole());
				String token = SessionUtils.getToken(request);
				loginUser.setToken(token);
				
				System.out.println(loginUser.getPhone());;
				session.setAttribute(SessionUtils.SIGN_IN_USER, u);
				session.setMaxInactiveInterval(10*60);
				
				return loginUser;
			}else{
				throw new OrtException(400,"账号密码不匹配");
			}
		}else{
			throw new OrtException(400,"没有此账号");
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> register(@RequestBody User user){
		Map<String,String> map = new HashMap<String,String>();
		//判断是否已有该用户
		List<User> userList = new ArrayList<User>();
		if(userList.size()==0){
			user.setRole("user");
			user.setCreattime(DateUtils.curDateTimeStr());
			user.setUpdatetime(DateUtils.curDateTimeStr());
			userService.addUser(user);
			map.put("message", "success");
		}else{
			map.put("message", "failure");
		}
		return map;
	}
	
	@RequestMapping(value="/logOut",method=RequestMethod.GET)
	@ResponseBody
	public void logOut(HttpServletRequest request){
		//清除会话信息
		System.out.println("注销成功");
		HttpSession session = request.getSession();
		session.invalidate();
	}
}
