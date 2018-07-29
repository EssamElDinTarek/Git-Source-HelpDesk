package com.sbm.helpdesk.persistence.dao;

import java.util.List;

import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.*;

public interface UserDao extends GenericDao<Hduser> {

	Hduser add(Hduser user) throws RespositoryException;

	List<Hduser> listUsers() throws RespositoryException;
	
	Hduser login(String email, String password) throws RespositoryException;
	
	Hduser findByEmail(String email) throws RespositoryException;

}
