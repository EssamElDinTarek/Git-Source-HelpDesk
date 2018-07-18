package com.sbm.helpdesk.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;

@Transactional
public interface UserDetailsService {
	
	public UserDetails loadUserByUsername(String email) throws BusinessException;
}
