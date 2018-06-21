package com.sbm.shura.service;

import java.util.List;

import com.sbm.shura.dto.UserDTO;

public interface UserService {
	
	UserDTO add(UserDTO user);

	List<UserDTO> listUsers();

	UserDTO login(String email, String password);
}
