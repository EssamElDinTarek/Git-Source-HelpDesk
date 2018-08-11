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
public class WorkflowServiceFacade {

	@Autowired
	private WorkflowService service;
	
	public ResponseDTO addWorkflow(WorkflowDTO workflowDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 WorkflowDTO _workflowDTO = service.addWorkflow(workflowDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Workflow added successfully", 
				"Workflow added successfully", null);
		result = new ResponseDTO(status, _workflowDTO);
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
	public ResponseDTO updateWorkflow(WorkflowDTO workflowDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 WorkflowDTO _workflowDTO = service.updateWorkflow(workflowDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Workflow updated successfully", 
				"Workflow updated successfully", null);
		result = new ResponseDTO(status, _workflowDTO);
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
	public ResponseDTO getWorkflowById(Long workflowId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 WorkflowDTO _workflow = service.getByWorkflowId(workflowId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Workflow updated successfully", 
				"Workflow updated successfully", null);
		result = new ResponseDTO(status, _workflow);
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
	public ResponseDTO deleteWorkflowById(Long workflowId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 String res = service.deleteWorkflow(workflowId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Workflow deleted successfully", 
				"Workflow deleted successfully", null);
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
	public ResponseDTO getAllWorkflow() throws ControllerException {
		ResponseDTO result = null;
		try {
		List<WorkflowDTO> _workflowList = service.getAllWorkflow();
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all WorkFlow successfully", 
				"get all WorkFlow successfully", null);
		result = new ResponseDTO(status, _workflowList);
		}catch(BusinessException e) {
			 e.printStackTrace();
			 throw new ControllerException(ExceptionEnums.BUSINESS_ERROR);
			}
		 catch(Exception e1) {
			 e1.printStackTrace();
			 throw new ControllerException(ExceptionEnums.INVALID_OPERATION);
		 }
		return result;
	}
	
}
