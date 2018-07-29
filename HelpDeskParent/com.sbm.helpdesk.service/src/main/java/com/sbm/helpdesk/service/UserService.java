package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface UserService {
	
	UserDTO add(UserDTO user) throws BusinessException;

	List<UserDTO> listUsers() throws BusinessException;

	UserDTO login(String email, String password) throws BusinessException;

	UserDTO getUserByEmailAddress(String emailAddress) throws BusinessException;
}
