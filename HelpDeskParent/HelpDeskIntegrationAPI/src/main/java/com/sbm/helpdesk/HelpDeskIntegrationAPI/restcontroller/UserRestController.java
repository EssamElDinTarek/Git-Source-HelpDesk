package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbm.helpdesk.dto.BaseDTO;
import com.sbm.helpdesk.dto.UserDTO;
import com.sbm.helpdesk.service.UserService;
import com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller.RestProvider;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserRestController {

	@Resource
	private UserService service;
	
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> register(@RequestBody UserDTO userDto){
		return dtoProvider.addObj(service.add(userDto));
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BaseDTO> login(@RequestBody Map<String, String> map) {
		return dtoProvider.getObj((UserDTO) service.login(map.get("email"), map.get("password")));
	}
	
	@RequestMapping(value = "/secure/user/getusers", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		return dtoProvider.getObjList((List) service.listUsers());
	}
}
