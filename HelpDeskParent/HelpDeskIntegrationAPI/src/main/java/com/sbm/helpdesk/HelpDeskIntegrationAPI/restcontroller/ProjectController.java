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
import com.sbm.helpdesk.dto.ProjectDTO;
import com.sbm.helpdesk.dto.UserDTO;
import com.sbm.helpdesk.entity.Project;
import com.sbm.helpdesk.service.HdGroupService;
import com.sbm.helpdesk.service.ProjectService;
import com.sbm.helpdesk.service.UserService;
import com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller.RestProvider;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {

	@Resource
	private ProjectService service;
	
	
	@Resource
	private RestDTOProvider dtoProvider;
	
	@RequestMapping(value = "/open", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String openProject(@RequestBody ProjectDTO projectDto){
		service.openProject(projectDto);
		return "Success";
	}
	
/*	@RequestMapping(value = "/assignPrivilge", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public boolean assignPrivilge(@RequestBody ProjectDTO hdgroup){
	  service.assignPrivilge(hdgroup);
				return true;
	}
	
	@RequestMapping(value = "/assignSubcomponents", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public boolean assignGroupSubcomponents(@RequestBody ProjectDTO hdgroupDTO){
	  service.assignSubcomponents(hdgroupDTO); 
				return true;
	}
//	
//	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<BaseDTO> login(@RequestBody Map<String, String> map) {
//		return dtoProvider.getObj((UserDTO) service.login(map.get("email"), map.get("password")));
//	}
//	
	@RequestMapping(value = "/", method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<ProjectDTO>> getAllUsers() {
		return dtoProvider.getObjList((List) service.listGroups());
	}*/
}
