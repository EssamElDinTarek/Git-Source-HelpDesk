package com.sbm.shura.dao;

import java.util.List;

import com.sbm.shura.entity.User;

public interface UserDao extends GenericDao<User> {

	User add(User user);

	List<User> listUsers();
	
	User login(String email, String password);
	
	User findByEmail(String email);

}
