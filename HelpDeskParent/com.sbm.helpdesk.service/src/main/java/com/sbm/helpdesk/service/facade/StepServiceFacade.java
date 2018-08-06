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
public class StepServiceFacade {

	@Autowired
	private StepService service;
	
	public ResponseDTO addStep(StepDTO stepDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 StepDTO _stepDTO = service.addStep(stepDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Step added successfully", 
				"Step added successfully", null);
		result = new ResponseDTO(status, _stepDTO);
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
	public ResponseDTO updateStep(StepDTO stepDTO) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 StepDTO _step = service.updateStep(stepDTO);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Step updated successfully", 
				"Step updated successfully", null);
		result = new ResponseDTO(status, _step);
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
	public ResponseDTO getStepById(Long stepId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 StepDTO _step = service.getByStepId(stepId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Step updated successfully", 
				"Step updated successfully", null);
		result = new ResponseDTO(status, _step);
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
	public ResponseDTO deleteStepById(Long stepId) throws ControllerException {
		ResponseDTO result = null;
		 try {
			 String res = service.deleteStep(stepId);
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
	public ResponseDTO getAllStep() throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<StepDTO> _stepList = service.getAllStep();
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all Step successfully", 
				"get all Step successfully", null);
		result = new ResponseDTO(status, _stepList);
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
