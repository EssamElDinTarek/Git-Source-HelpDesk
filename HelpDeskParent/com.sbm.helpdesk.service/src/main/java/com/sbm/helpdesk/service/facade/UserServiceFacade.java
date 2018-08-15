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
public class UserServiceFacade {

	@Autowired
	private UserService service;
	
	@Autowired
	private HduserService hduserservice;
	
	
	public ResponseDTO findByProjectId(long projectId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<HduserDTO> _userList = hduserservice.findByProjectId(projectId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all portfolio successfully", 
				"get all portfolio successfully", null);
		result = new ResponseDTO(status, _userList);
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
	public ResponseDTO findByPortfolioId(long portfolioId) throws ControllerException {
		ResponseDTO result = null;
		 try {
		List<HduserDTO> _userList = hduserservice.findByPortfolioId(portfolioId);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"get all portfolio successfully", 
				"get all portfolio successfully", null);
		result = new ResponseDTO(status, _userList);
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
