package com.sbm.helpdesk.service.dao;

import java.util.List;

import com.sbm.helpdesk.service.entity.Hduser;

public interface UserDao extends GenericDao<Hduser> {

	Hduser add(Hduser user);

	List<Hduser> listUsers();
	
	Hduser login(String email, String password);
	
	Hduser findByEmail(String email);

}
