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
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.persistence.dao.*;
import com.sbm.helpdesk.persistence.entity.*;
import com.sbm.helpdesk.common.dto.*;

@Service
public class UserServiceImpl extends BasicServiceImpl<UserDTO, Hduser> implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	Hduser _user = new Hduser();

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
		System.out.println("Hello2: "+userListResult.get(0).getTeam() + "  and: " + userListResult.get(0).getProjects().get(0).getName());
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
	
	@Override
	public UserDTO getUserByEmailAddress(String emailAddress) throws BusinessException {
		UserDTO result;
		try {
			Hduser user = userDao.findByEmail(emailAddress);
			System.out.println("Test2: " + user.getProjects().toString());
			UserDTO userDTO = new UserDTO();
			result =  convertToDTO(user,userDTO);
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
	

}
