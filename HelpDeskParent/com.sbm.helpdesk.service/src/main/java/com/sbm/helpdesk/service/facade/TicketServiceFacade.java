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
	
	public ResponseDTO creatTicket(TicketDTO ticketdto) throws BusinessException {
		TicketDTO newTicket = service.addTicket(ticketdto);
		if(newTicket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been added successfully", 
				"Ticket has been added successfully", null);
		return new ResponseDTO(status, newTicket) ;
	}
	public ResponseDTO updateTicket(TicketDTO ticketdto) throws BusinessException {
		TicketDTO _ticket = service.updateTicket(ticketdto);
		if(_ticket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been updated successfully", 
				"Ticket has been updated successfully", null);
		return new ResponseDTO(status, _ticket) ;
	}
	public ResponseDTO deleteTicket(Long ticketId) throws BusinessException {
		service.deleteTicket(ticketId);
		//TODO ResponseStatusDTO
		return new ResponseDTO(null, "Sucsses") ;
	}
	
	public ResponseDTO getTicketByIdentifier(String key, String value) throws BusinessException {
		TicketDTO _ticket = null;
		switch (key) {
		case IntegrationServicesConstant.TICKET_ID:
			_ticket = service.getByTicketId(Long.parseLong(value));
			break;
		case IntegrationServicesConstant.TICKET_NUMBER:
			_ticket = service.getByTicketNumber(value);
			break;

		}
		/*if(_ticket == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);*/
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Ticket has been retrived successfully", 
				"Ticket has been retrived successfully", null);
		
		return new ResponseDTO(null, _ticket);
	}
	
	public ResponseDTO getTiketListByIdentifier(String key, String value) throws BusinessException {
		List<TicketDTO> _ticketList = null;
		switch (key) {
		case IntegrationServicesConstant.PROJECT_NAME:
			_ticketList = service.getTicketByProjectName(value);
			break;
		}
		/*if(_ticketList == null)
			throw new BusinessException(ExceptionEnums.BUSINESS_ERROR);*/
		
		ResponseStatusDTO status = new ResponseStatusDTO("helpdesk.business.code.3001", 
				"Tickets has been retrived successfully", 
				"Tickets has been retrived successfully", null);
		
		return new ResponseDTO(null, _ticketList);
	}
	

}
