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
public class ProjectServiceFacade {

	@Autowired
	private ProjectService service;
	
	
	public ResponseDTO openProject(ProjectDTO projectDto){
		service.openProject(projectDto);
		return new ResponseDTO(null,"success" );
	}

	public ResponseDTO addProject(ProjectDTO projectDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 ProjectDTO _projectDTO = service.addProject(projectDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Step added successfully", 
				"Step added successfully", null);
		result = new ResponseDTO(status, _projectDTO);
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
	public ResponseDTO updateProject(ProjectDTO projectDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 ProjectDTO _projectDTO = service.updateProject(projectDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Step updated successfully", 
				"Step updated successfully", null);
		result = new ResponseDTO(status, _projectDTO);
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
	public ResponseDTO getProjectById(Long projectId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 ProjectDTO _projectDTO = service.getByProjectId(projectId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Step updated successfully", 
				"Step updated successfully", null);
		result = new ResponseDTO(status, _projectDTO);
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
	public ResponseDTO deleteProjectById(Long projectId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 String res = service.deleteProject(projectId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Step deleted successfully", 
				"Step deleted successfully", null);
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
	public ResponseDTO getAllProject() throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<ProjectDTO> _projectList = service.getAllProject();
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all Step successfully", 
				"get all Step successfully", null);
		result = new ResponseDTO(status, _projectList);
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
	public ResponseDTO getAllProjectByPortfolioId(Long portfolioId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<ProjectDTO> _projectList = service.getProjectByPortfolioId(portfolioId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all Step successfully", 
				"get all Step successfully", null);
		result = new ResponseDTO(status, _projectList);
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
	public ResponseDTO getDashBoardProject(Long portfolioId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<ProjectDBDetailsDTO> _projectList = service.getDashBoardProject(portfolioId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all Step successfully", 
				"get all Step successfully", null);
		result = new ResponseDTO(status, _projectList);
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
