package com.sbm.helpdesk.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbm.helpdesk.dao.UserDao;
import com.sbm.helpdesk.dto.UserDTO;
import com.sbm.helpdesk.entity.User;
import com.sbm.helpdesk.service.UserService;

@Service
public class UserServiceImpl extends BasicServiceImpl<UserDTO, User> implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	private User _user = new User();
		
	public UserServiceImpl() {}

	@Override
	@Transactional
	public UserDTO add(UserDTO userDto) 
	{
		
		_user = convertToEntity(_user , userDto);
		_user = userDao.add(_user);
		return convertToDTO(_user,userDto);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDTO> listUsers() {
		List<User> userListResult =  userDao.listUsers();
		List<UserDTO> userDtoList =  userListResult.stream().
				map(item -> convertToDTO(item, new UserDTO())).collect(Collectors.toList());
		return userDtoList;
		 
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO login(String email, String password) {
		
		_user = userDao.login(email, password);
		if (_user == null) {
			return new UserDTO(-1L);
		}
		 UserDTO userDto = new UserDTO();
		 userDto =  convertToDTO(_user,userDto);
		 return userDto;
	}
	
	@Override
	protected void configureMapperLocally()
	{
		modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
			protected void configure() {
				map().setUsername(source.getUsername());
				}
		});
	}

}
