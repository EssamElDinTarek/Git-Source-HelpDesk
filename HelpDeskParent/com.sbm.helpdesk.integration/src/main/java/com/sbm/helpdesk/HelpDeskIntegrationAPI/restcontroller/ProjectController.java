package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;


import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.service.facade.ProjectServiceFacade;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.common.dto.*;

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
	
	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addProject(@RequestBody ProjectDTO projectDTO) throws ControllerException {
			return facadeService.addProject(projectDTO);
	}
	@RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO updateProject(@RequestBody ProjectDTO projectDTO) throws ControllerException {
			return facadeService.updateProject(projectDTO);
	}
	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllProject() throws ControllerException {
			return facadeService.getAllProject();
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.PROJECT_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deletePortfolio(@PathVariable(IntegrationServicesConstant.PROJECT_ID) Long projectId) throws ControllerException {
			return facadeService.deleteProjectById(projectId);
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.PROJECT_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getPortfolioById(@PathVariable(IntegrationServicesConstant.PROJECT_ID) Long projectId) throws ControllerException {
			return facadeService.getProjectById(projectId);
	}
	@RequestMapping(value = "/getByPortfolioId", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getProjectByPortfolioId(@RequestParam(IntegrationServicesConstant.PORTFOLIO_ID) Long portfolioId) throws ControllerException {
		return facadeService.getAllProjectByPortfolioId(portfolioId);
	}
}
