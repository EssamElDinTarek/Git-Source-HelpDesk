package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;


import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.facade.ProjectServiceFacade;
import com.sbm.helpdesk.common.dto.ResponseDTO;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {

	@Resource
	private ProjectServiceFacade facadeService;
	
	
	
	
	@RequestMapping(value = "/open", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO openProject(@RequestBody ProjectDTO projectDto){
		return facadeService.openProject(projectDto);
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
