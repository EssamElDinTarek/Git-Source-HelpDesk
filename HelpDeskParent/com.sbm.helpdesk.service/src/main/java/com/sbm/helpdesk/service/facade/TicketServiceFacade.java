package com.sbm.helpdesk.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sbm.helpdesk.common.dto.*;
import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;
import com.sbm.helpdesk.common.exceptions.types.*;
import com.sbm.helpdesk.common.constant.IntegrationServicesConstant;
import com.sbm.helpdesk.service.*;
import com.sbm.helpdesk.service.dto.*;

@Service
public class TicketServiceFacade {

	@Autowired
	private TicketService service;
	
	public ResponseDTO creatTicket(TicketDTO ticketdto) throws ControllerException {
		ResponseDTO result = null;
		 try {
		TicketDTO newTicket = service.addTicket(ticketdto);
		if(newTicket == null)
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION);
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been added successfully", 
				"Ticket has been added successfully", null);
		result = new ResponseDTO(status, newTicket) ;
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
	public ResponseDTO updateTicket(TicketDTO ticketdto) throws ControllerException {
		ResponseDTO result = null;
		try {
		TicketDTO ticket = service.updateTicket(ticketdto);
		if(ticket == null)
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION);
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been updated successfully", 
				"Ticket has been updated successfully", null);
		result = new ResponseDTO(status, ticket) ;
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
	public ResponseDTO deleteTicket(Long ticketId) throws ControllerException {
		ResponseDTO result = null;
		try {
		service.deleteTicket(ticketId);
		//TODO ResponseStatusDTO
		result = new ResponseDTO(null, "Sucsses") ;
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
	
	public ResponseDTO getTicketByIdentifier(String key, String value) throws ControllerException {
		ResponseDTO result = null;
		try {
		TicketDTO ticket = null;
		switch (key) {
		case IntegrationServicesConstant.TICKET_ID:
			ticket = service.getByTicketId(Long.parseLong(value));
			break;
		case IntegrationServicesConstant.TICKET_NUMBER:
			ticket = service.getByTicketNumber(value);
			break;

		}
			if(ticket == null)
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION);
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been retrived successfully", 
				"Ticket has been retrived successfully", null);
		
		result = new ResponseDTO(status, ticket);
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
	
	public ResponseDTO getTiketListByIdentifier(String key, String value) throws ControllerException {
		ResponseDTO result = null;
		try {
		List<TicketDTO> ticketList = null;
		switch (key) {
		case IntegrationServicesConstant.PROJECT_NAME:
			ticketList = service.getTicketByProjectName(value);
			break;
		}
		if(ticketList == null)
			throw new ControllerException(ExceptionEnums.INVALID_OPERATION);
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Tickets has been retrived successfully", 
				"Tickets has been retrived successfully", null);
		
		result = new ResponseDTO(status, ticketList);
		
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
