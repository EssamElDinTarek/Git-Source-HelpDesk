package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.service.ProjectService;
import com.sbm.helpdesk.service.dto.*;
import com.sbm.helpdesk.service.facade.ProjectServiceFacade;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.dto.ResponseDTO;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;

@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {

	@Resource
	private ProjectServiceFacade facadeService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private RestDTOProvider dtoProvider;
	
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
	
	@RequestMapping(value = "/getProjectById", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<BaseDTO> getProjectById(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) Long projectId) throws BusinessException {
		
		return dtoProvider.getObj((ProjectDTO) projectService.getProjectById(projectId));
	}
	
	@RequestMapping(value = "/getByPortfolioId", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<ProjectDTO>> getProjectByPortfolioId(@RequestParam(IntegrationServicesConstant.SERVICE_RETRIVAL_VALUE) Long portfolioId) throws BusinessException {
		return dtoProvider.getObjList((List) projectService.getProjectByPortfolioId(portfolioId));
	}
}
