package com.sbm.helpdesk.service.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.service.*;

@Service
public class TeamServiceFacade {

	@Autowired
	private TeamService service;
	
	public ResponseDTO addTeam(TeamDTO teamDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 TeamDTO _teamDTO = service.addTeam(teamDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Team added successfully", 
				"Team added successfully", null);
		result = new ResponseDTO(status, _teamDTO);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO updateTeam(TeamDTO teamDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 TeamDTO _team = service.updateTeam(teamDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Team updated successfully", 
				"Team updated successfully", null);
		result = new ResponseDTO(status, _team);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO getTeamById(Long teamId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 TeamDTO _team = service.getByTeamId(teamId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Team updated successfully", 
				"Team updated successfully", null);
		result = new ResponseDTO(status, _team);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO deleteTeamById(Long teamId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 String res = service.deleteTeam(teamId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Team deleted successfully", 
				"Team deleted successfully", null);
		result = new ResponseDTO(status, res);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO getAllTeam() throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<TeamDTO> _teamList = service.getAllTeam();
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all Team successfully", 
				"get all Team successfully", null);
		result = new ResponseDTO(status, _teamList);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}
	public ResponseDTO getProjectTeamsandMembersCount(Long projectId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<WidgetDTO> list = service.getProjectTeamsandMembersCount(projectId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all Team successfully", 
				"get all Team successfully", null);
		result = new ResponseDTO(status, list);
		 }catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION,e1);
		 }
		 return result;
	}

}
