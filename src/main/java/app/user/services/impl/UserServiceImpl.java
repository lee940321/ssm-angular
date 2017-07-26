package app.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.user.dao.UserCustomMapper;
import app.user.dao.UserMapper;
import app.user.model.User;
import app.user.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserCustomMapper userCustomMapper;
	
	@Override
	public void addUser(User user){
		userMapper.insert(user);
	}
	
	@Override
	public User getUserByPhone(String phone){
		return userCustomMapper.getUserByPhone(phone);
	}
	
}
