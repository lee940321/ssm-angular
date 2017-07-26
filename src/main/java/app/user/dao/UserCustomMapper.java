package app.user.dao;

import app.user.model.User;

public interface UserCustomMapper {

	User getUserByPhone(String phone);
}
