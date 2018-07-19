package com.sbm.helpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
//import com.sbm.helpdesk.service.UserDetailsService;
import com.sbm.helpdesk.service.dao.UserDao;
import com.sbm.helpdesk.service.entity.Hduser;;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Hduser user = null;
    	try {
    	user = userDao.findByEmail(email);
    	}catch(RespositoryException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		}
		catch(Exception e1) {
			e1.printStackTrace();
			throw new UsernameNotFoundException(e1.getMessage());
	    	}
        return user;
    }
}