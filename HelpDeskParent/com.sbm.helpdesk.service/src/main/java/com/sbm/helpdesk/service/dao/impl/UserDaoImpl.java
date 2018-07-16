package com.sbm.helpdesk.service.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sbm.helpdesk.service.dao.UserDao;
import com.sbm.helpdesk.service.entity.Hduser;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Hduser>  implements UserDao{


	@Override
	public Hduser add(Hduser user) {
		return persist(user);
	}

	@Override
	public List<Hduser> listUsers() {
		List<Hduser> users =  entityManager.createNamedQuery("Hduser.findAll", Hduser.class).getResultList();
		return users;
	}

	@Override
	public Hduser login(String email, String password) {
		try {
			Query q = entityManager.createNamedQuery("Hduser.findByEmailAndPassword", Hduser.class);
			q.setParameter("emailAddress", email);
			q.setParameter("userPassword", password);
			return (Hduser) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public Hduser findByEmail(String email) {
		try {
			Query q = entityManager.createNamedQuery("Hduser.findByEmail", Hduser.class);
			q.setParameter("emailAddress", email);
			Hduser userObj = (Hduser) q.getSingleResult();
			return userObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
