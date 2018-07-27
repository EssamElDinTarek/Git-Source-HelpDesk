package com.sbm.helpdesk.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Hduser>  implements UserDao{


	@Override
	public Hduser add(Hduser user) throws RespositoryException {
		return persist(user);
	}

	@Override
	public List<Hduser> listUsers() throws RespositoryException {
		List<Hduser> users;
		try {
		users =  entityManager.createNamedQuery("Hduser.findAll", Hduser.class).getResultList();
		}
		catch(Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
		   }
		return users;
	}

	@Override
	public Hduser login(String email, String password) throws RespositoryException {
		
		Hduser result = null;
		try {
			Query q = entityManager.createNamedQuery("Hduser.findByEmailAndPassword", Hduser.class);
			q.setParameter("emailAddress", email);
			q.setParameter("userPassword", password);
			result = (Hduser) q.getSingleResult();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Hduser findByEmail(String email) throws RespositoryException {
		Hduser userObj = null;
		try {
			Query q = entityManager.createNamedQuery("Hduser.findByEmail", Hduser.class);
			q.setParameter("emailAddress", email);
			userObj = (Hduser) q.getSingleResult();
		} catch (Exception e) {
			throw new RespositoryException(ExceptionEnums.REPOSITORY_ERROR);
//			e.printStackTrace();
		}
		return userObj;
	}

}
