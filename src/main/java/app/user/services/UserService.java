package app.user.services;

import app.user.model.User;

public interface UserService {
	
	public void addUser(User user);
	
	User getUserByPhone(String phone);
	

}
