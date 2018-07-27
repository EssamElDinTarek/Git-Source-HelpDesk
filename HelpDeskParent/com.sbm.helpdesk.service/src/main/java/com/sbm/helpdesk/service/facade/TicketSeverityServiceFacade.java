package com.sbm.helpdesk.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.BusinessException;
import com.sbm.helpdesk.common.exceptions.types.ControllerException;
import com.sbm.helpdesk.service.TicketSeverityService;

@Service
public class TicketSeverityServiceFacade {

	@Autowired
	private TicketSeverityService service;
	
	public ResponseDTO getAllTicketSeverity() throws ControllerException {
		ResponseDTO result = null;
		try {
		List<TicketSeverityDTO> _ticketSeverityList = service.getAllTicketSeverity();
		result = new ResponseDTO(null, _ticketSeverityList);
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
