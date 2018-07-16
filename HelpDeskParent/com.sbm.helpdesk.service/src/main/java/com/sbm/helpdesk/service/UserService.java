package com.sbm.helpdesk.service;

import java.util.List;
import javax.transaction.Transactional;

import com.sbm.helpdesk.service.dto.UserDTO;

@Transactional
public interface UserService {
	
	UserDTO add(UserDTO user);

	List<UserDTO> listUsers();

	UserDTO login(String email, String password);
}
