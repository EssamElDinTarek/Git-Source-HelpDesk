package com.sbm.helpdesk.service;

import java.util.List;

import com.sbm.helpdesk.dto.UserDTO;

public interface UserService {
	
	UserDTO add(UserDTO user);

	List<UserDTO> listUsers();

	UserDTO login(String email, String password);
}
