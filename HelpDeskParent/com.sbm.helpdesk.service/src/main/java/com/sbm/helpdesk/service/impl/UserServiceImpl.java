package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.RespositoryException;
import com.sbm.helpdesk.service.UserService;
import com.sbm.helpdesk.service.dao.UserDao;
import com.sbm.helpdesk.service.dto.UserDTO;
import com.sbm.helpdesk.service.entity.Hduser;

@Service
public class UserServiceImpl extends BasicServiceImpl<UserDTO, Hduser> implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	private Hduser _user = new Hduser();
		
	public UserServiceImpl() {}

	@Override
	@Transactional
	public UserDTO add(UserDTO userDto) throws BusinessException 
	{
		UserDTO result = null;
		try {
		_user = convertToEntity(_user , userDto);
		_user = userDao.add(_user);
		result = convertToDTO(_user,userDto);
		
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> listUsers() throws BusinessException {
		List<UserDTO> result;
		try {
		List<Hduser> userListResult =  userDao.listUsers();
		result =  userListResult.stream().
				map(item -> convertToDTO(item, new UserDTO())).collect(Collectors.toList());
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		return result;
		 
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO login(String email, String password) throws BusinessException {
		UserDTO result = null;
		try {
		_user = userDao.login(email, password);
		if (_user == null) {
			result = new UserDTO(-1L);
		}
		 UserDTO userDto = new UserDTO();
		 result =  convertToDTO(_user,userDto);
		 
		}catch(RespositoryException e) {
			e.printStackTrace();
			throw new BusinessException(ExceptionEnums.REPOSITORY_ERROR);
		}
		catch(Exception e1) {
			e1.printStackTrace();
	    	throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
	    	}
		 return result;
	}
	
	@Override
	protected void configureMapperLocally()
	{
		modelMapper.addMappings(new PropertyMap<Hduser, UserDTO>() {
			protected void configure() {
				map().setUsername(source.getUsername());
				}
		});
	}

}
