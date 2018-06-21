package com.sbm.helpdesk.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.sbm.helpdesk.dao.UserDao;
import com.sbm.helpdesk.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User>  implements UserDao{


	@Override
	public User add(User user) {
		return persist(user);
	}

	@Override
	public List<User> listUsers() {
		List<User> users =  entityManager.createNamedQuery("User.findAll", User.class).getResultList();
		return users;
	}

	@Override
	public User login(String email, String password) {
		try {
			Query q = entityManager.createNamedQuery("User.findByEmailAndPassword", User.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			return (User) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public User findByEmail(String email) {
		try {
			Query q = entityManager.createNamedQuery("User.findByEmail", User.class);
			q.setParameter("email", email);
			User userObj = (User) q.getSingleResult();
			return userObj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
