package com.sbm.helpdesk.HelpDeskIntegrationAPI.restcontroller;

import javax.annotation.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.service.facade.*;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;

@RestController
@RequestMapping("/api/team")
@CrossOrigin("*")
public class TeamRestController {

	@Resource
	private TeamServiceFacade facadeService;

	@RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO addTeam(@RequestBody TeamDTO teamDTO) throws ControllerException {
			return facadeService.addTeam(teamDTO);
	}
	@RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO updateTeam(@RequestBody TeamDTO teamDTO) throws ControllerException {
			return facadeService.updateTeam(teamDTO);
	}
	@RequestMapping( method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getAllTeam() throws ControllerException {
			return facadeService.getAllTeam();
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.TEAM_ID+"}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO deleteTeam(@PathVariable(IntegrationServicesConstant.TEAM_ID) Long teamDTO) throws ControllerException {
			return facadeService.deleteTeamById(teamDTO);
	}
	@RequestMapping(value="/{"+IntegrationServicesConstant.TEAM_ID+"}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getTeamById(@PathVariable(IntegrationServicesConstant.TEAM_ID) Long teamId) throws ControllerException {
			return facadeService.getTeamById(teamId);
	}
	@RequestMapping(value="/projectmemberandcount", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDTO getProjectTeamsandMembersCount(@RequestParam(IntegrationServicesConstant.PROJECT_ID) Long projectId) throws ControllerException {
			return facadeService.getProjectTeamsandMembersCount(projectId);
	}

}
