package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.persistence.entity.Hduser;
import com.sbm.helpdesk.common.dto.*;

@Transactional
public interface UserService {
	
	public UserDTO add(UserDTO user) throws BusinessException;

	public List<UserDTO> listUsers() throws BusinessException;

	public UserDTO login(String email, String password) throws BusinessException;

	public UserDTO getUserByEmailAddress(String emailAddress) throws BusinessException;
	
}
