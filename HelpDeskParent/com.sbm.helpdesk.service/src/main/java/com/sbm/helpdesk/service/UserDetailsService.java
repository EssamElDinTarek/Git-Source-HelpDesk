package com.sbm.helpdesk.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;

@Transactional
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService{
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
